package com.depeng.v3;

/**
 * @ClassName: RequestLine
 * @Author: Yan Depeng
 * @Date: 2022/9/22 19:08
 * @Version: 1.0.0
 */
public class RequestLine {

    public byte[] method;
    public int methodEnd;

    public byte[] protocol;
    public int protocolEnd;

    public int uriEnd;

}
