package com.automan.siberia.brage.bridgeTset;


/**
 * @Author: he.zhou
 * @Date: 2018-10-22
 */
public abstract class Msg {
    private SendMsgInterface sendMsgInterface;
    public Msg(SendMsgInterface sendMsgInterface) {
        this.sendMsgInterface = sendMsgInterface;
    }
    public abstract void send();
}
