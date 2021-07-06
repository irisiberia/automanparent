package com.automan.siberia.redis;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author he.zhou
 * @date 2019/12/13
 **/
@Slf4j
public class JedisLock {


    private static final Lock NO_LOCK = new Lock(new UUID(0l, 0l), 0l);

    private static final int ONE_SECOND = 1000;

    /**
     * 锁超时时间，防止线程在入锁以后，无限的执行等待
     */
    public static final int DEFAULT_EXPIRY_TIME_MILLIS = Integer.getInteger("com.github.jedis.lock.expiry.millis", 10 * ONE_SECOND);

    /**
     * 锁等待时间，防止线程饥饿
     */
    public static final int DEFAULT_ACQUIRE_TIMEOUT_MILLIS = Integer.getInteger("com.github.jedis.lock.acquiry.millis", 3 * ONE_SECOND);

    public static final int DEFAULT_ACQUIRY_RESOLUTION_MILLIS = Integer.getInteger("com.github.jedis.lock.acquiry.resolution.millis", 1);

    private JedisPool jedisPool;

    private final String lockKeyPath;

    private final int lockExpiryInMillis;
    private final int acquiryTimeoutInMillis;
    private final UUID lockUUID;

    private static final int DEAMON_SLEEP_TIME = 10000;

    private int MAX_LOCK_COUNT = 10;
    private static final ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

    private static AtomicInteger lockCount = new AtomicInteger(0);


    private Lock lock = null;

    protected static class Lock {
        private UUID uuid;
        private long expiryTime;

        protected Lock(UUID uuid, long expiryTimeInMillis) {
            this.uuid = uuid;
            this.expiryTime = expiryTimeInMillis;
        }

        protected static Lock fromString(String text) {
            try {
                String[] parts = text.split(":");
                UUID theUUID = UUID.fromString(parts[0]);
                long theTime = Long.parseLong(parts[1]);
                return new Lock(theUUID, theTime);
            } catch (Exception any) {
                return NO_LOCK;
            }
        }

        public UUID getUUID() {
            return uuid;
        }

        public long getExpiryTime() {
            return expiryTime;
        }

        @Override
        public String toString() {
            return uuid.toString() + ":" + expiryTime;
        }

        boolean isExpired() {
            return getExpiryTime() < System.currentTimeMillis();
        }

        boolean isExpiredOrMine(UUID otherUUID) {
            return this.isExpired() || this.getUUID().equals(otherUUID);
        }
    }


    /**
     * Detailed constructor with default acquire timeout 10000 msecs and lock
     * expiration of 60000 msecs.
     *
     * @param lockKey lock key (ex. account:1, ...)
     */
    public JedisLock(JedisPool jedisPool, String lockKey) {
        this(jedisPool, lockKey, DEFAULT_ACQUIRE_TIMEOUT_MILLIS, DEFAULT_EXPIRY_TIME_MILLIS);
    }

    /**
     * Detailed constructor with default lock expiration of 60000 msecs.
     *
     * @param lockKey              lock key (ex. account:1, ...)
     * @param acquireTimeoutMillis acquire timeout in miliseconds (default: 10000 msecs)
     */
    public JedisLock(JedisPool jedisPool, String lockKey, int acquireTimeoutMillis) {
        this(jedisPool, lockKey, acquireTimeoutMillis, DEFAULT_EXPIRY_TIME_MILLIS);
    }

    /**
     * Detailed constructor.
     *
     * @param lockKey              lock key (ex. account:1, ...)
     * @param acquireTimeoutMillis acquire timeout in miliseconds (default: 10000 msecs)
     * @param expiryTimeMillis     lock expiration in miliseconds (default: 60000 msecs)
     */
    public JedisLock(JedisPool jedisPool, String lockKey, int acquireTimeoutMillis, int expiryTimeMillis) {
        this(jedisPool, lockKey, acquireTimeoutMillis, expiryTimeMillis, UUID.randomUUID());
    }

    /**
     * Detailed constructor.
     *
     * @param lockKey              lock key (ex. account:1, ...)
     * @param acquireTimeoutMillis acquire timeout in miliseconds (default: 10000 msecs)
     * @param expiryTimeMillis     lock expiration in miliseconds (default: 60000 msecs)
     * @param uuid                 unique identification of this lock
     */
    public JedisLock(JedisPool jedisPool, String lockKey, int acquireTimeoutMillis, int expiryTimeMillis, UUID uuid) {
        this.jedisPool = jedisPool;
        this.lockKeyPath = lockKey;
        this.acquiryTimeoutInMillis = acquireTimeoutMillis;
        this.lockExpiryInMillis = expiryTimeMillis + 1;
        this.lockUUID = uuid;
        startDeamon();
    }

    private void startDeamon() {
        if (lockCount.incrementAndGet() <= MAX_LOCK_COUNT) {
            singleThreadExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    for (; ; ) {
                        try {
                            ping();
                        } finally {
                            try {
                                Thread.sleep(DEAMON_SLEEP_TIME);
                            } catch (Exception e) {
                            }
                        }
                    }
                }
            });
        } else {
            log.warn("too many jedisLock can't init more deamon");
        }
    }


    public void ping() {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.ping();
        } catch (Exception e) {
            log.error("ping", e);
        } finally {
            if (null != jedis) {
                jedis.close();
            }
        }
    }

    /**
     * @return lock uuid
     */
    public UUID getLockUUID() {
        return lockUUID;
    }

    /**
     * @return lock key path
     */
    public String getLockKeyPath() {
        return lockKeyPath;
    }

    /**
     * Acquire lock.
     *
     * @return true if lock is acquired, false acquire timeouted
     * @throws InterruptedException in case of thread interruption
     */
    public synchronized boolean acquire() throws InterruptedException {
        return acquire(jedisPool);
    }

    /**
     * 获得 lock. 实现思路:
     * 主要是使用了redis 的setNX命令,缓存了锁. reids缓存的key是锁的key,
     * 所有的
     * 时间(注意:这里把过期时间放在value了,没有时间上设置其超时时间) 执行过程:
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
                //getExpiryTime() < System.currentTimeMillis() 如果被其他线程设置了值，则第二个条件判断(uuid)是过不去的
                if (currentLock.isExpiredOrMine(lockUUID)) {
                    log.info("redis.acquire, isExpiredOrMine,lockKeyPath={},currentLock={}", lockKeyPath, currentLock);
                    // 获取上一个锁到期时间，并设置现在的锁到期时间，
                    // 只有一个线程才能获取上一个线上的设置时间，因为jedis.getSet是同步的.
                    String oldValueStr = jedis.getSet(lockKeyPath, newLock.toString());
                    // 防止误删（覆盖，因为key是相同的）了他人的锁
                    //     ——这里达不到效果，这里值会被覆盖，但是因为什么相差了很少的时间，所以可以接受
                    //        [分布式的情况下]:
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

    /**
     * Renew lock.
     *
     * @return true if lock is acquired, false otherwise
     * @throws InterruptedException in case of thread interruption
     */
    public boolean renew() throws InterruptedException {
        Jedis jedis = jedisPool.getResource();
        try {
            final Lock lock = Lock.fromString(jedis.get(lockKeyPath));
            if (!lock.isExpiredOrMine(lockUUID)) {
                return false;
            }
        } finally {
            jedis.close();
        }
        return acquire(jedisPool);
    }

    /**
     * Acquired lock release.
     */
    public synchronized void release() {
        Jedis jedis = jedisPool.getResource();
        try {
            release(jedis);
        } finally {
            jedis.close();
        }
    }

    /**
     * Acquired lock release.
     *
     * @param jedis
     */
    protected synchronized void release(Jedis jedis) {
        if (isLocked()) {
            //jedis.del(lockKeyPath);
            List<String> keys = new ArrayList<>();
            List<String> args = new ArrayList<>();
            keys.add(lockKeyPath);
            args.add(this.lock.toString());
            Object result = jedis.eval("if redis.call(\"get\",KEYS[1]) == ARGV[1] then return redis.call(\"del\",KEYS[1]) else return 0 end\n" +
                    "\n", keys, args);
            try {
                log.info("redisLock.release ,key={}, arg={}, result={}", lockKeyPath, this.lock.toString(), new ObjectMapper().writeValueAsString(result));
            } catch (Exception e) {
                log.error("redisLock.release", e);
            }
            this.lock = null;
        }
    }

    /**
     * Check if owns the lock
     *
     * @return true if lock owned
     */
    public synchronized boolean isLocked() {
        return this.lock != null;
    }

    /**
     * Returns the expiry time of this lock
     *
     * @return the expiry time in millis (or null if not locked)
     */
    public synchronized long getLockExpiryTimeInMillis() {
        return this.lock.getExpiryTime();
    }


    private Lock asLock(long expires) {
        return new Lock(lockUUID, expires);
    }
}
