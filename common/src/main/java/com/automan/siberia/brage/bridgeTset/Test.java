package com.automan.siberia.brage.bridgeTset;

/**
 * @Author: he.zhou
 * @Date: 2018-10-22
 */
public class Test {
    public static void main(String[] args) {
//      SendMsgInterface sendMsgInterface = new PhoneSendMsg();
        SendMsgInterface senMail=new EmailSendMsg();
        Msg msg=new ImportantMsg(senMail);
        senMail.sendMsg();
        msg.send();
    }
}
