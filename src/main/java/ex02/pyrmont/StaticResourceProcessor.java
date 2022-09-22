package ex02.pyrmont;

import java.io.IOException;

/**
 * @ClassName: StaticResourceProcessor
 * @Author: Yan Depeng
 * @Date: 2022/9/21 15:51
 * @Version: 1.0.0
 */
public class StaticResourceProcessor {
    public void process(Request request, Response response) {
        try {
            response.sendStaticResource();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
