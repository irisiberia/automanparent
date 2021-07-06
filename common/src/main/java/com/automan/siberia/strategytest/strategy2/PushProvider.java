package com.automan.siberia.strategytest.strategy2;

import com.automan.root.utils.Safes;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author: he.zhou
 * @Date: 2019-04-12
 */
@Component
public class PushProvider {

    @Resource
    private List<PushData> pushDataList;

    @Autowired
    private Map<String, PushData> dataMap;

    public static Map<Integer, PushData> pushDataMap = Maps.newHashMap();

    @PostConstruct
    private void init() {
        pushDataMap = pushDataList.stream().collect(Collectors.toMap(PushData::type, y -> y));
        System.out.println("ssss");
        Safes.of(dataMap).forEach((key, value) -> System.out.println(key + "======" + value.type()));
    }

    public PushData doProvider(int type) {
        return pushDataMap.get(type);
    }

}
