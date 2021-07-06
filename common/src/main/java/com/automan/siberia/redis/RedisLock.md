### 
``` 
 /**
     * 获得 lock. 实现思路:
     * 主要是使用了redis 的setNX命令,缓存了锁. reids缓存的key是锁的key,
     * 所有的共享,value是锁的到期时间(注意:这里把过期时间放在value了,没有时间上设置其超时时间) 执行过程:
     * 1.通过setnx尝试设置某个key的值,成功(当前没有这个锁)则返回,成功获得锁
     * 2.锁已经存在则获取锁的到期时间,和当前时间比较,超时的话,则设置新的值
     *
     * @return true if lock is acquired, false acquire timeouted
     * @throws InterruptedException in case of thread interruption
     */

    protected synchronized boolean acquire(JedisPool jedisPool) throws InterruptedException {
        //锁等待时间
        int timeout = acquiryTimeoutInMillis;
        Jedis jedis = jedisPool.getResource();
        try {
            while (timeout > 0) {
                //设置锁到期时间
                final Lock newLock = asLock(System.currentTimeMillis() + lockExpiryInMillis);
                if (jedis.setnx(lockKeyPath, newLock.toString()) == 1) {
                    this.lock = newLock;
                    return true;
                }
                log.info("redis.acquire, setnx,lockKeyPath={},newLock={}", lockKeyPath, newLock.toString());
                //redis 里面的时间
                final String currentValueStr = jedis.get(lockKeyPath);
                final Lock currentLock = Lock.fromString(currentValueStr);
                //getExpiryTime() < System.currentTimeMillis() 如果被其他线程设置了值，则第二个条件判断是过不去的
                if (currentLock.isExpiredOrMine(lockUUID)) {
                    log.info("redis.acquire, isExpiredOrMine,lockKeyPath={},currentLock={}", lockKeyPath, currentLock);
                    // 获取上一个锁到期时间，并设置现在的锁到期时间，
                    // 只有一个线程才能获取上一个线上的设置时间，因为jedis.getSet是同步的.
                    String oldValueStr = jedis.getSet(lockKeyPath, newLock.toString());
                    // 防止误删（覆盖，因为key是相同的）了他人的锁
                    //     ——这里达不到效果，这里值会被覆盖，但是因为什么相差了很少的时间，所以可以接受
                    // [分布式的情况下]:
                    //        如果这个时候，多个线程恰好都到了这里，但是只有一个线程的设置值和当前值相同，他才有权利获取锁
                    //        lock acquire

                    //todo 为什么前面的锁已经超时了，还要用getSet去设置新的时间戳的时间获取旧的值，然后和外面的判断超时时间的时间戳比较呢？
                    //因为是分布式的环境下，可以在前一个锁失效的时候，有两个进程进入到锁超时的判断。如：
                    //C0超时了，还持有锁,C1/C2同时请求进入了方法里面
                    //C1/C2获取到了C0的超时时间
                    //C1使用getSet方法
                    //C2也执行了getSet方法
                    //假如我们不加 oldValueStr.equals(currentValueStr) 的判断，将会C1/C2都将获得锁，加了之后，能保证C1和C2只能一个能获得锁，一个只能继续等待。
                    if (oldValueStr != null && oldValueStr.equals(currentValueStr)) {
                        this.lock = newLock;
                        return true;
                    }
                }
                timeout -= DEFAULT_ACQUIRY_RESOLUTION_MILLIS;

                //延迟100 毫秒,  这里使用随机时间可能会好一点,可以防止饥饿进程的出现,即,当同时到达多个进程,
                //                只会有一个进程获得锁,其他的都用同样的频率进行尝试,后面有来了一些进行,也以同样的频率申请锁,这将可能导致前面来的锁得不到满足.
                //                使用随机的等待时间可以一定程度上保证公平性
                Thread.sleep(DEFAULT_ACQUIRY_RESOLUTION_MILLIS);
            }
        } finally {
            jedis.close();
        }

        return false;
    }
```