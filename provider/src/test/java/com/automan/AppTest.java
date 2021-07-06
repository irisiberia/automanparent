package com.automan;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.automan.bean.PersonOne;
import com.automan.siberia.abstractTestServe.AbstractTest;
import com.automan.siberia.abstractTestServe.TestImpl;
import com.automan.siberia.adapterTset1.Window2Impl;
import com.automan.siberia.adapterTset1.WindowAdapter;
import com.automan.siberia.adapterTset1.WindowImpl;
import com.automan.siberia.aspect.annotationTest.ArithmeticCalculator;
import com.automan.siberia.aspect.annotationTest.AutoService;
import com.automan.bean.AlertRecord;
import com.automan.siberia.java8InterfaceTest.Window1Impl;
import com.automan.siberia.aspect.FactoryTest.FactoryBeanTest;
import com.automan.siberia.retry.OrderService;
import com.automan.siberia.workrder.WorkOrderTest;
import com.automan.siberia.strategytest.strategy2.PushProvider;
import com.google.common.collect.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-config.xml")
public class AppTest {

    @Resource
    private AlertRecordService alertRecordService;

    @Resource
    private ArithmeticCalculator arithmeticCalculator;

    @Resource(name = "dsds")
    private AlertRecord dsdsds;

    @Resource
    private AutoService autoService;

    @Resource
    private WindowImpl window;

    @Resource
    private Window2Impl window2;

    @Resource
    private Window1Impl window1;

//    @Autowired
//    private FactoryBeanTest factoryBeanTest;

    @Resource
    private PushProvider pushProvider;

    @Autowired
    private WorkOrderTest workOrderTest;

//    @Autowired
//    private PersonOne personOne;

//    @Autowired
//    private OrderService orderService;




//    @Test
//    public void test003() {
//        System.out.println(orderService.getOrder());
//    }

//    @Test
//    public void test002() {
//        System.out.println(JSONObject.toJSON(personOne));
//    }

    @Test
    public void test001() {
        dsdsds.setAlertName("sss");
        System.out.println(JSONObject.toJSON(dsdsds));
    }

    @Test
    public void test() {

        ReentrantLock lock =new ReentrantLock();
        lock.lock();
        lock.unlock();
        List<AlertRecord> recordList = Lists.newArrayList(
//                new AlertRecord.Builder().shopCode("1111").shopName("测试1").macAddress("a").alertName("ddhjh").build(),
                new AlertRecord.Builder().shopCode("1119").shopName("测试2").macAddress("b").alertName("ddhjh").build(),
                new AlertRecord.Builder().shopCode("1419").shopName("测试3").macAddress("c").alertName("ddhjh").build(),
                new AlertRecord.Builder().shopCode("1518").shopName("测试4").macAddress("d").alertName("ddhjh").build()
        );

//        alertRecordService.insert(recordList);

//        System.out.println(JSON.toJSON(recordList));
//        List<ShopSkuSign> list = alertRecordService.getAll();
//        System.out.println(list);
    }

    @Test
    public void test1() {
        System.out.println(arithmeticCalculator.add(2, 4));
//        arithmeticCalculator.sub(9, 5);

    }

    @Test
    public void test2() {
//        System.out.println("开始:" + JSONObject.toJSONString(alertRecord));
//        alertRecord.setAlertName("dhdjdjj");
//        alertRecord.setId(3333);
//        System.out.println("结束:" + JSONObject.toJSONString(alertRecord));

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(dsdsds);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(dsdsds);
            }
        }).start();

    }

    @Test
    public void test3() throws Exception {
        System.out.println("最终计算" + autoService.add(2, 4));
        workOrderTest.test();
    }

    @Test
    public void test4() {
        WindowImpl window = new WindowImpl();
        window.close();
        window.open();
        window.iconified();
        System.out.println(window.myTest());

        System.out.println("================");
        window2.close();
        window2.open();
        window2.iconified();


        WindowAdapter adapter = new WindowAdapter() {
            @Override
            public String getWidowName() {
                return "ddddddd";
            }
        };

        System.out.println(((WindowAdapter) adapter).getWidowName());
    }

    @Test
    public void test5() {
        window1.open();
    }

    //单例测试
    @Test
    public void test7() {
//        ApplicationContext context = new FileSystemXmlApplicationContext("classpath:spring-config.xml");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AlertRecord.class);
//        AlertRecord alertRecord = (AlertRecord) context.getBean("alertRecord");
//        alertRecord.setAlertName("dnbjbkjbj");
        AlertRecord alertRecord1 = (AlertRecord) context.getBean("alertRecord");

        System.out.println(JSON.toJSON(dsdsds));
        System.out.println(JSON.toJSON(alertRecord1));
    }

    @Test
    public void test8() {
//        Window window = new Window1Impl();
//        window.open();
//        window.iconified();
//
//        new AbstractTest<String>() {
//            @Override
//            public void start() {
//
//            }
//
//            public int step() {
//                return 666;
//            }
//
//            @Override
//            public String end() {
//                return "测试";
//            }
//        }.doResult();

//
//        System.out.println(test.doResult());

        AbstractTest test = new TestImpl("3", "4");
        ((TestImpl) test).myOwn();
        System.out.println(test.error());
        System.out.println(test.doResult());
//
//        System.out.println(new TestImpl("3","4").doResult());
    }

//    @Test
//    public void test9() {
//        try {
//            FactoryBeanTest record = factoryBeanTest;
//            System.out.println(record.getObject());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    /**
     * 策略模式测试
     */
    @Test
    public void test10() {
        pushProvider.doProvider(1).operate();
    }
}
