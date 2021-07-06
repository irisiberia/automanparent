package com.automan.siberia.retry;

import com.automan.root.utils.util.JsonUtil;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author he.zhou
 * @date 2019/10/11
 **/
//@Component
//@EnableRetry
public class OrderService {

    private static int i = 1;

    @Retryable(value = Exception.class, maxAttempts = 3, backoff = @Backoff(delay = 2L))
    @Recover
    public String getOrder() {
        System.out.println("第" + i + "次执行方法");
        i++;
        throw new RuntimeException();
    }

    @Recover
    public String recover(RuntimeException ne) {
        return "RuntimeException recover";
    }

    public static void main(String[] args) {
         Map map = Maps.newHashMap();
         map.put("dsd","Dsdsd");
        System.out.println(JsonUtil.of(map));
    }
}
