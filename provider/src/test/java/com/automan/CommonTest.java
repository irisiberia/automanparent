package com.automan;

import com.automan.bean.PostCust;
import com.automan.invite.InviteTest;
import com.automan.root.utils.util.JsonUtil;
import com.automan.siberia.Arrange;
import com.automan.siberia.brage.bridgeTest2.XiaoMi;
import com.automan.siberia.decorator.test4.AddChocolate;
import com.automan.siberia.decorator.test4.BigIceCream;
import com.automan.springTest.cirDependency.TestB;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author he.zhou
 * @date 2019/10/12
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-config.xml")
public class CommonTest {

    @Resource
    private Arrange arrange;

    @Resource
    private InviteTest inviteTest;

    @Autowired
    private XiaoMi xiaoMi;

    @Resource
    private AddChocolate addChocolate;

    @Resource
    private BigIceCream bigIceCream;

    @Autowired
    private PostCust postCust;

    @Autowired
    TestB testB;

    @Autowired
    private AlertRecordService alertRecordService;

    @Test
    public void testFiller() {
        System.out.println(JsonUtil.of(alertRecordService.getInventory()));
    }

    @Test
    public void tetsA() {
        System.out.println(testB.getInt());
    }

    @Test
    public void testPostCust() {
        postCust.test();
    }

    private static final ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();


    @Test
    public void testbigIceCream() {
        ReentrantLock lock = new ReentrantLock(true);
        lock.lock();

        addChocolate.setIceCream(bigIceCream);
        System.out.println(addChocolate.teast());
        lock.unlock();
    }

    @Test
    public void testPhone() {
        xiaoMi.creatphone();
    }

    @Test
    public void setInviteTestd() {

    }

    @Test
    public void test2323() {
        arrange.setCode("Eeee");
        System.out.println(JsonUtil.of(arrange));
    }

    @Test
    public void test11() {
        System.out.println(inviteTest);
    }

    @Test
    public void testSingle() {
//        while (true){
//            singleThreadExecutor.
//        }

    }

}
