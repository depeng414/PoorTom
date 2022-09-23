package com.depeng.v3;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName: SocketInputStream
 * @Description:
 * 1、该类扩展了readRequestLine()和
 * @Author: Yan Depeng
 * @Date: 2022/9/22 17:13
 * @Version: 1.0.0
 */
public class SocketInputStream extends InputStream {

    private InputStream input;

    private int scoopSize = 1024;

    public SocketInputStream(InputStream input) {
        this.input = input;
    }

    public SocketInputStream(InputStream input, int scoopSize) {
        this.input = input;
        this.scoopSize = scoopSize;
    }

    public void readRequestLine(RequestLine requestLine) {
        // TODO
    }

    @Override
    public int read() throws IOException {
        return 0;
    }
}
