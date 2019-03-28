package com.gupaoedu.nio;

/**
 * Created by 召君王 on 2019/3/29.
 */
public class TimeServer
{

    public static void main(String[] args) {
        int port = 4700;
        String ip = "127.0.0.1";
        MultiplexerTimeServer timeServer = new MultiplexerTimeServer(ip,port);

        new Thread(timeServer, "NIO-Server-01").start();
    }
}
