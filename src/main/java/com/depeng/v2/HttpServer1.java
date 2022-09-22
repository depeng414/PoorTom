package com.depeng.v2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName: HttpServer1
 * @Author: Yan Depeng
 * @Date: 2022/9/21 10:46
 * @Version: 1.0.0
 */
public class HttpServer1 {
    private static final String SHUTDOMN_COMMAND = "/SHUTDOMN";
    private boolean shutDown = false;

    public static void main(String[] args) {
        HttpServer1 server= new HttpServer1();
        server.await();
    }

    public void await() {
        ServerSocket serverSocket = null;
        int port = 8080;
        try {
            serverSocket = new ServerSocket(port, 1,
                    InetAddress.getByName("127.0.0.1"));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        // loop waiting for a request
        while (!shutDown) {
            Socket socket = null;
            InputStream input = null;
            OutputStream output = null;

            try {
                socket = serverSocket.accept();
                input = socket.getInputStream();
                output = socket.getOutputStream();

                // create request object and parse
                Request request = new Request(input);
                request.parse();

                if (null == request.getUri())
                    continue;

                // create response objest
                Response response = new Response(output);
                response.setRequest(request);

                // check if this is a request for a servlet or
                // a static resource
                // a request for a servlet begins with "/servlet"
                if (request.getUri().startsWith("/servlet")) {
                    ServletProcessor1 processor = new ServletProcessor1();
                    processor.process(request, response);
                } else {
                    StaticResourceProcessor processor = new StaticResourceProcessor();
                    processor.process(request, response);
                }

                // close the socket
                socket.close();
                // check if the previous URI is a shoutdomn command
                shutDown = request.getUri().equals(SHUTDOMN_COMMAND);
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }
    }
}
