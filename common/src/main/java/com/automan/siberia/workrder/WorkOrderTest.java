package com.automan.siberia.workrder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author he.zhou
 * @date 2019/9/18
 **/
@Component
public class WorkOrderTest {

    private QueueOrder queueOrder;

    @Autowired
    private InRoomQueueOrder inRoomQueueOrder;

    @Autowired
    private IMOnlineQueueOrder imOnlineQueueOrder;

    @Autowired
    private List<QueueOrder> queueOrderList;

    public void setQueueOrder(List<QueueOrder> queueOrder) {
        QueueOrder source = null;
        for (QueueOrder order : queueOrder) {
            order.setSource(source);
            source = order;
        }
        this.queueOrder = source;
    }

    public void test() throws Exception {
        System.out.println(queueOrder.getQueue(12L).getFirst());;
    }
}
