package com.automan.siberia.nio.bioTest;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class BioServer {
    public static byte[] bs = new byte[1024];

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            System.out.println(" wait conn");
            //阻塞 放弃cpu
            Socket socket = serverSocket.accept();

            System.out.println("conn success");
            System.out.println(" wait data");

            //阻塞 放弃cpu
            socket.getInputStream().read(bs);
            System.out.println("data success");
            System.out.println(" =====" + new String(bs) + "=====");
        }
    }
}
