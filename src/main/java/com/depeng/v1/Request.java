package com.depeng.v1;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName: Request
 * @Author: Yan Depeng
 * @Date: 2022/9/20 10:31
 * @Version: 1.0.0
 */
public class Request {
    private InputStream input;
    private String uri;

    public Request(InputStream input) {
        this.input = input;
    }

    public String getUri() {
        return uri;
    }

    public void parse() {
        // 读取socket中的信息
        StringBuffer request = new StringBuffer(2048);
        int i;
        byte[] buffer = new byte[2048];

        try {
            i = input.read(buffer);
        } catch (IOException e) {
            e.printStackTrace();
            i = -1;
        }
        for (int j =0; j<i; j++) {
            request.append((char) buffer[j]);
        }
        System.out.println("request => \r\n" + request.toString());
        uri = parseUri(request.toString());

    }

    /**
     * 该方法从请求中获取URI。
     * 搜索第一个和第二个空格，从中找出URI
     * @param requestString
     * @return
     */
    private String parseUri(String requestString) {
        int index1, index2;
        index1 = requestString.indexOf(" ");
        if (index1 != -1) {
            index2 = requestString.indexOf(" ", index1 + 1);
            if (index1 < index2)
                return requestString.substring(index1 + 1, index2);
        }
        return null;
    }
}
