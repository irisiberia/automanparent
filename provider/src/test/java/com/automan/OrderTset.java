package com.automan;

import com.alibaba.fastjson.JSONObject;
import com.automan.siberia.abstractOrderService.CheckOrder;
import com.automan.siberia.abstractOrderService.ExpireOrder;
import com.automan.siberia.abstractOrderService1.ExpireOrderBiz;
import com.automan.siberia.aspect.AspectTest.Authenticator;
import com.automan.siberia.aspect.AspectTest.Calculator.ArithCalculaor;
import com.automan.siberia.aspect.AspectTest.DataAuthenticationAdvice;

import com.automan.siberia.chain.ConcreteHandler;
import com.automan.siberia.chain.Handler;
import com.automan.siberia.chain.SecondHandler;
import com.automan.siberia.chain.ThirdHandler;
import com.automan.siberia.factorytest.abstractFactory2.StudentDao;
import com.automan.siberia.spiTest.Robot;
import com.automan.siberia.workrder.order1.QueueManger;
import org.junit.Test;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;
import java.util.ServiceLoader;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author: he.zhou
 * @Date: 2018-12-24
 */
public class OrderTset extends AppTest {

    @Resource
    private ExpireOrder expireOrder;

    @Resource
    private ExpireOrderBiz expireOrderBiz;

    @Resource
    private CheckOrder checkOrder;

    @Resource
    private ArithCalculaor arithCalculaor;

    @Resource
    private List<StudentDao> daoList;

    @Resource
    private QueueManger queueManger;


    @Resource
    private ConcreteHandler concreteHandler;

    @Resource
    private SecondHandler secondHandler;

    @Resource
    private ThirdHandler thirdHandler;

    @Resource
    private DataAuthenticationAdvice dataAuthenticationAdvice;


    @Test
    public void testFactory() {
        for (StudentDao studentDao : daoList) {
            studentDao.save();
        }
        System.out.println(daoList.size());
    }

    @Test
    public void test() {
        System.out.println(expireOrder.generate());
        System.out.println("----------------");
        System.out.println(checkOrder.queryById());

        System.out.println(expireOrder.test());

        System.out.println(JSONObject.toJSONString(expireOrderBiz.queryById()));
        System.out.println(JSONObject.toJSONString(expireOrderBiz.queryByCondition()));
    }


    @Test
    public void test2() {
        try {
            Class clz = Class.forName("com.automan.bean.AlertRecord");
            Method setPriceMethod = clz.getMethod("setShopCode", String.class);
            Constructor appleConstructor = clz.getConstructor();
            Object appleObj = appleConstructor.newInstance();
            setPriceMethod.invoke(appleObj, "232");
            Method getPriceMethod = clz.getMethod("getShopCode");
            System.out.println("Apple Price:" + getPriceMethod.invoke(appleObj));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void Tset3() throws Exception {
//        System.out.println(arithCalculaor.add(3, 7));
        queueManger.test();
    }

    @Test
    public void Test4() {
        List<Authenticator> authenticatorList = dataAuthenticationAdvice.getAuthenticators();
        System.out.println(JSONObject.toJSONString(authenticatorList));
    }

    @Test
    public void sayHello() throws Exception {
        ServiceLoader<Robot> serviceLoader = ServiceLoader.load(Robot.class);
        System.out.println("Java SPI");
        serviceLoader.forEach(Robot::sayHello);
    }

}
