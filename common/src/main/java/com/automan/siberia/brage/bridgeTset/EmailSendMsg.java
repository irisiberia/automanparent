package com.automan.siberia.brage.bridgeTset;

import org.springframework.stereotype.Service;

/**
 * @Author: he.zhou
 * @Date: 2018-10-22
 */
@Service
public class EmailSendMsg implements SendMsgInterface{
    @Override
    public void sendMsg() {
        System.out.println("邮件:发送邮件成功");
    }
}
