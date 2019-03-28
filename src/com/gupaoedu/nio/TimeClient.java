package com.gupaoedu.nio;

/**
 * Created by 召君王 on 2019/3/29.
 */
public class TimeClient {

    public static void main(String[] args) {
        String ip ="127.0.0.1";
        int port = 4700;
        if(null != args && args.length > 0)
        {
            port = Integer.valueOf(args[0]);
        }
        new Thread(new TimeClientHandler(ip,port)).start();

    }
}
