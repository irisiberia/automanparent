package com.automan.siberia.nio;

import com.google.common.collect.Lists;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.List;

/**
 * @Author: he.zhou
 * @Date: 2019-08-04
 */
public class QQService {

    static List<SocketChannel> channelList = Lists.newArrayList();
    static ByteBuffer buffer = ByteBuffer.allocate(512);

    public static void main(String[] args) {
        try {
            //非阻塞
            ServerSocketChannel channel = ServerSocketChannel.open();
            channel.bind(new InetSocketAddress(8080));
            channel.configureBlocking(false);
            while (true) {
                SocketChannel socketChannel = channel.accept();
                if (socketChannel == null) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("no coon");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
