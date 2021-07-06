package com.automan.siberia.ingestion;

import com.automan.siberia.ingestion.recorder.LogRecorder;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

import java.util.concurrent.ConcurrentHashMap;


/**
 * 数据收集工厂
 * <p>
 * <pre>
 * Collector collector = CollectorFactory.getCollector("service.sub_service,subject");
 *
 * collector.track()
 *          .set("name", "北京饭店")
 *          .set("city", "beijing")
 *          .set("postcode", "100000")
 *          .set("rank", 0.991922493)
 *          .set("count", 123456789123456)
 *          .flush()
 * </pre>
 * <p>
 *
 * @Author: he.zhou
 * @Date: 2019-04-09
 */
public class CollectorFactory {

    private static CollectorFactory INSTANCE = new CollectorFactory();

    private static ConcurrentHashMap<String, Collector> collectors = new ConcurrentHashMap<String, Collector>();

    private CollectorFactory() {
    }

    public synchronized static Collector getCollector(String key) {
        Preconditions.checkNotNull(key, "key不能为空");

        Collector collector = collectors.get(key);
        if (collector != null) {
            return collector;
        }

        collector = INSTANCE.createCollector(key);
        collectors.put(key, collector);

        return collector;
    }

    private Collector createCollector(String key) {
        return new JsonCollector(key, ImmutableList.<Recorder>of(createRecorder(Recorder.Type.log)));
    }

    private Recorder createRecorder(Recorder.Type type) {

        if (type == Recorder.Type.log) {
            return LogRecorder.getDefaultRecorder();
        }

        // TODO throw exception?
        return null;
    }
}
