package com.automan.siberia.redis;

/**
 * @Author: he.zhou
 * @Date: 2019-04-26
 */
public abstract class AbstractTemplate<T> {

    public T execute() {

        Boolean isLock = lock("", "", "");
        if (isLock) {
            try {
                return success();
            } finally {
                unLock("", "", "");
            }
        } else {
            return fail();
        }

    }

    public abstract T success();

    public abstract T fail();

    private boolean lock(String key, String value, String expireTime) {
        //sentX加锁
        Boolean isSuccess = true;

        if (isSuccess) {
            //加锁成功，添加过期时间

        } else {
            //看没有过期时间，没有加一个过期时间
            //if（redis.ttl(key)==-1）{ expire}
        }
        return isSuccess;
    }

    private void unLock(String key, String value, String expireTime) {
      //删除key
    }
}