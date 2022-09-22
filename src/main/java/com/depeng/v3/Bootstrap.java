package com.depeng.v3;

/**
 * @ClassName: Bootstrup
 * @Description: 启动器
 * @Author: Yan Depeng
 * @Date: 2022/9/22 16:29
 * @Version: 1.0.0
 */
public class Bootstrap {
    public static void main(String[] args) {
        HttpConnector httpConnector = new HttpConnector();
        httpConnector.start();
    }
}
