package com.automan.siberia.workrder.order1;

import com.google.common.collect.Lists;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author he.zhou
 * @date 2019/9/23
 **/
@Component
public class QueueManger {

    @Resource
    private List<QueueDecorate> queueDecorateList;

    private QueueDecorate queueDecorate;

    @PostConstruct
    private void init() {
        queueDecorate = queueDecorateList.get(queueDecorateList.size() - 1);
    }


    public void test() throws Exception {
        System.out.println(queueDecorateList.get(queueDecorateList.size() - 1).getQueue(12L).getFirst());
    }

    public static void main(String[] args) {
        LinkedHashMap<String,String> hashMap = new LinkedHashMap();
        hashMap.put("4","4");
        hashMap.put("3","4");
        hashMap.put("2","4");
        hashMap.put("1","4");
        HashMap<String,String> hashMap1 = new HashMap();
        hashMap1.put("4","4");
        hashMap1.put("3","3");
        hashMap1.put("2","2");
        hashMap1.put("1","1");

        hashMap1.entrySet().forEach(ar->{
            System.out.println(ar.getKey());
        });




    }

}
