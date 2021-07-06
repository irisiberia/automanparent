package com.automan.siberia.brage.bridgeTset;

/**
 * @Author: he.zhou
 * @Date: 2018-10-22
 */
public class NormaMsg extends Msg {

    public NormaMsg(SendMsgInterface sendMsgInterface) {
        super(sendMsgInterface);
    }

    @Override
    public void send() {
        System.out.println("普通消息");
    }
}
