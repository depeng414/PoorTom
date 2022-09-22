package com.depeng.v3;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @ClassName: HttpProcessor
 * @Description: http连接器
 * @Author: Yan Depeng
 * @Date: 2022/9/22 16:36
 * @Version: 1.0.0
 */
public class HttpProcessor {

    private HttpConnector connector;

    public HttpProcessor(HttpConnector connector) {
        this.connector = connector;
    }

    private HttpRequest request;
    private HttpResponse response;

    public void process(Socket socket) {
        SocketInputStream input = null;
        OutputStream output = null;
        try {
            input = new SocketInputStream(socket.getInputStream(), 2048);
            output = socket.getOutputStream();

            // create HttpRequest object and parse
            request = new HttpRequest(input);

            // create HttpResponse Object
            response = new HttpResponse(output);
            response.setRequest(request);

            response.setHeader("Server", "Pyrmont Servlet Container");

            // TODO parseRequest
            // TODO parseHeaders

            // check if this is a request for a servlet or static resource
            // a request for a servlet begins with "/servlet/"
            if (request.getRequestURI().startsWith("/servlet/")) {
                // TODO 创建servletProcessor
                // TODO 把request,response传入其中
            } else {
                // TODO 将request,response传入staticProcessor，处理静态资源
            }
            // close socket
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void parseRequest(SocketInputStream input, OutputStream output) {

    }
}
