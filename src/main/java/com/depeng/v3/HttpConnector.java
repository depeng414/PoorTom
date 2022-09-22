package com.depeng.v3;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName: HttpConnector
 * @Description: http连接器
 * @Author: Yan Depeng
 * @Date: 2022/9/22 16:13
 * @Version: 1.0.0
 */
public class HttpConnector implements Runnable{

    boolean stopped;
    private String scheme = "http";

    public String getScheme() {
        return scheme;
    }

    @Override
    public void run() {
        ServerSocket serverSocket = null;
        int port = 8080;

        try {
            serverSocket = new ServerSocket(port, 1,
                    InetAddress.getByName("127.0.0.1"));
        } catch (IOException e) {
            e.printStackTrace();
            // 非正常退出
            System.exit(1);
        }

        while (!stopped) {
            Socket socket = null;
            try {
                socket = serverSocket.accept();
            } catch (IOException e) {
                // 继续重试
                continue;
            }
            // 将socket传给http处理器
            HttpProcessor processor = new HttpProcessor(this);
            processor.process(socket);
        }
    }

    public void start() {
        Thread thread = new Thread(this);
        thread.start();
    }
}
