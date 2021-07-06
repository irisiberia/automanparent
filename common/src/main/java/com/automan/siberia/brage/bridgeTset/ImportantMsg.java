package com.automan.siberia.brage.bridgeTset;

/**
 * @Author: he.zhou
 * @Date: 2018-10-22
 */
public class ImportantMsg extends Msg {
    public ImportantMsg(SendMsgInterface sendMsgInterface) {
        super(sendMsgInterface);
    }
    @Override
    public void send() {
        System.out.println("紧急消息");
    }
}
