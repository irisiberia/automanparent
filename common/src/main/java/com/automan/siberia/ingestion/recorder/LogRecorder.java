package com.automan.siberia.ingestion.recorder;


import com.automan.siberia.ingestion.Record;
import com.automan.siberia.ingestion.Recorder;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

import java.io.File;
import java.io.IOException;

/**
 * 使用Logback记录数据到文件, 文件路径默认为${wormpex.logs}/logs/${name}/.%d{yyyy-MM-dd_HH}.log
 * <p>
 * <ul>
 * <li>wormpex.logs 系统环境变量</li>
 * <li>name 收集器名称</li>
 * <li>yyyy-MM-dd_HH Logback日志切分策略，可定制</li>
 * </ul>
 *
 * @Author: he.zhou
 * @Date: 2019-04-09
 */
public class LogRecorder extends GenericRecorder {

    private static final Supplier<String> store = Suppliers.memoize(new Supplier<String>() {
        @Override
        public String get() {

            String path = System.getProperty("wormpex.logs", null);

            if (path == null) {
                path = System.getProperty("catalina.base");
                if (path == null) {path = System.getProperty("java.io.tmpdir");}
                path = path + File.separator + "logs";
                System.setProperty("wormpex.logs", path);
            }

            File file = new File(path);
            file.mkdirs();
            try {
                path = file.getCanonicalPath();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return path;
        }
    });


    private final String loggerName = "data_ingestion";

    private LogRecorder(String name) {
        super(name, Recorder.Type.log);
    }

    private static final LogRecorder DEFAULT = new LogRecorder("log");

    public static GenericRecorder getDefaultRecorder() {
        return DEFAULT;
    }

    @Override
    public void record(final Record record) {
        System.out.println(record.data());
    }
}
