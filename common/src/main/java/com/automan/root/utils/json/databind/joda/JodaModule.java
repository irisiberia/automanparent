package com.automan.root.utils.json.databind.joda;import com.fasterxml.jackson.databind.JsonDeserializer;import com.fasterxml.jackson.datatype.joda.cfg.JacksonJodaDateFormat;import com.fasterxml.jackson.datatype.joda.deser.DateTimeDeserializer;import org.joda.time.DateTime;import org.joda.time.ReadableInstant;import org.joda.time.format.DateTimeFormat;/** * @Author he.zhou * @Date 2020-07-21 */public class JodaModule extends com.fasterxml.jackson.datatype.joda.JodaModule {    protected JacksonJodaDateFormat jacksonJodaDateFormat;    public JodaModule(String pattern) {        jacksonJodaDateFormat = new JacksonJodaDateFormat(DateTimeFormat.forPattern(pattern));        addSerializer(DateTime.class, new DateTimeSerializer(jacksonJodaDateFormat, false));        addDeserializer(DateTime.class, forType(DateTime.class));    }    @SuppressWarnings("unchecked")    public <T extends ReadableInstant> JsonDeserializer<T> forType(Class<T> cls) {        return (JsonDeserializer<T>) new DateTimeDeserializer(cls, jacksonJodaDateFormat);    }}