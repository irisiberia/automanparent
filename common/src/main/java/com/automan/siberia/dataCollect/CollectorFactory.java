package com.automan.siberia.dataCollect;

import com.automan.siberia.ingestion.JsonCollector;
import com.automan.siberia.ingestion.Recorder;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import org.springframework.util.StringUtils;

import java.util.Objects;
import java.util.concurrent.ConcurrentMap;

/**
 * @Author: he.zhou
 * @Date: 2019-04-12
 */
public class CollectorFactory {

    private static CollectorFactory instance = new CollectorFactory();

    private static ConcurrentMap<String, Collector> collectorMap = Maps.newConcurrentMap();

    public static Collector getCollector(String key, String type) {
        if (StringUtils.isEmpty(key) || StringUtils.isEmpty(type)) {
            throw new RuntimeException();
        }

        if (Objects.isNull(collectorMap.get(key))) {
            synchronized (CollectorFactory.class) {
                if (Objects.isNull(collectorMap.get(key))) {
                    collectorMap.put(key, instance.createCollector(key, type));
                }
            }
        }


        return null;
    }

    private Collector createCollector(String key, String type) {
        return null;
    }

    private Recorder createRecorder(Recorder.Type type) {
        return null;
    }
}
