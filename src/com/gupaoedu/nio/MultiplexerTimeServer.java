package com.gupaoedu.nio;

import com.sun.deploy.util.StringUtils;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by 召君王 on 2019/3/29.
 */
public class MultiplexerTimeServer implements Runnable{
    private int port;

    private ServerSocketChannel ssc;

    private Selector selector;

    private volatile boolean stop;


    public MultiplexerTimeServer(String ip ,int port) {
        try {
            ssc = ServerSocketChannel.open();
            selector = Selector.open();
            ssc.configureBlocking(false);
            ssc.socket().bind(new InetSocketAddress(ip,port), 1024);
            ssc.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("Server start on port:"+ port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        while (!stop)
        {
            try {
                selector.select();
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> it = selectionKeys.iterator();
                while (it.hasNext())
                {
                    SelectionKey key = it.next();
                    it.remove();
                    handInputKey(key);

                }


            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void handInputKey(SelectionKey key) throws IOException {
        if(key.isValid())
        {
            if(key.isAcceptable())
            {
               ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
                SocketChannel sc = serverSocketChannel.accept();
                sc.configureBlocking(false);
                sc.register(selector, SelectionKey.OP_READ);
            }
            if(key.isReadable())
            {
               SocketChannel sc = (SocketChannel) key.channel();
                ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                int read = sc.read(readBuffer);
                if(read > 0) {
//                    readBuffer.flip();//??
                    byte[] bytes = new byte[readBuffer.remaining()];
                    readBuffer.get(bytes);
                    String body = new String(bytes);
                    System.out.println("thie time sever receive order" + body);

                    String currentTime = (new Date()).toString();
                    doWrite(sc,currentTime);
                }
                if(read < 0)
                {
                    key.channel();
                    sc.close();
                }


            }
        }
    }

    private void doWrite(SocketChannel sc, String currentTime) throws IOException {
        if(currentTime == null || currentTime.trim().length() == 0)
        {
            return;
        }
        ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
        byte[] bytes = currentTime.getBytes();
        writeBuffer.flip();
        writeBuffer.put(bytes);
        sc.write(writeBuffer);
        writeBuffer.clear();
    }
}

