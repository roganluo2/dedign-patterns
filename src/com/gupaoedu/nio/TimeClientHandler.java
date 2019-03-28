package com.gupaoedu.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by 召君王 on 2019/3/29.
 */
public class TimeClientHandler implements Runnable {
    private String ip;

    private int port;

    private ByteBuffer writeBuffer = ByteBuffer.allocate(1024);

    private ByteBuffer readBuffer = ByteBuffer.allocate(1024);

    private Selector selector = null;
    private SocketChannel socketChannel = null;

    private volatile boolean stop = false;

    public TimeClientHandler(String ip, int port) {

        this.ip = ip;
        this.port = port;

        try {
            selector = Selector.open();
            socketChannel = SocketChannel.open();
            //not blocking
            socketChannel.configureBlocking(false);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void run() {
        try {
            doConnect();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        while (!stop)
        {
            try {
                selector.select(1000);
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext())
                {
                    SelectionKey next = iterator.next();
                    iterator.remove();
                    handleInput(next);

                }


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(selector != null)
        {
            try {
                selector.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void handleInput(SelectionKey key) throws IOException {

        if(key.isValid())
        {
            SocketChannel channel = (SocketChannel) key.channel();
            if(key.isConnectable())
            {
                if(channel.finishConnect())
                {
                    socketChannel.register(selector, SelectionKey.OP_READ);
                    doWrite(socketChannel);
                }
                else {
                    System.exit(-1);
                }
            }
            if(key.isReadable())
            {
                readBuffer.clear();
                int read = socketChannel.read(readBuffer);

                if(read > 0)
                {
                    byte [] bytes = new byte[readBuffer.remaining()];
                    readBuffer.get(bytes);
                    String body = new String (bytes);
                    System.out.println("Now is :" + body);
                    this.stop = true;

                }
                else if(read < 0)
                {
                    key.cancel();
                    socketChannel.close();
                }
                else {

                }

            }


        }

    }

    private void doConnect() throws IOException {
        if(socketChannel.connect(new InetSocketAddress(ip,port))){
            socketChannel.register(selector, SelectionKey.OP_READ);//??read
            doWrite(socketChannel);
        }else
        {
            socketChannel.register(selector, SelectionKey.OP_CONNECT);
        }

    }

    private void doWrite(SocketChannel socketChannel) throws IOException {
        String str = "client query time order";
        writeBuffer.put(str.getBytes());
        writeBuffer.flip();
        socketChannel.write(writeBuffer);
        if(writeBuffer.hasRemaining())
        {
            System.out.println("send order 2 server success");
        }
        writeBuffer.clear();

    }
}
