package com.automan.siberia.brage.bridgeTset;

import org.springframework.stereotype.Service;

/**
 * @Author: he.zhou
 * @Date: 2018-10-22
 */
@Service
public class PhoneSendMsg implements SendMsgInterface {
    @Override
    public void sendMsg() {
        System.out.println("手机：手机发送信息成功");
    }
}