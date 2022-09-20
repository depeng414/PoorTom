package ex01.pyrmont;

import java.io.*;

/**
 * @ClassName: Response
 * @Author: Yan Depeng
 * @Date: 2022/9/20 11:16
 * @Version: 1.0.0
 */
public class Response {
    /*
    HTTP Response = status-line
        *((general-header | response-header | entity-header) CRLF)
        CRLF
        [message-body]
        status-line = HTTP-Version sp status-code sp reason-phrase CRLF
     */

    private static final int BUFFER_SIZE = 1024;
    Request request;
    OutputStream output;

    public Response(OutputStream output) {
        this.output = output;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    /**
     * 发送静态资源到浏览器，如html文件
     * @throws IOException
     */
    public void sendStaticResource() throws IOException {
        byte[] bytes = new byte[BUFFER_SIZE];
        FileInputStream fis = null;

        try {
            File file = new File(HttpServer.WEB_ROOT, request.getUri());
            if (file.exists()) {
                fis = new FileInputStream(file);
                int ch = fis.read(bytes, 0, BUFFER_SIZE);
                while (ch != -1) {
                    output.write(bytes, 0, ch);
                    ch = fis.read(bytes, 0, BUFFER_SIZE);
                }
            } else {
                // file not found
                String errorMesssage = "HTTP/1.1 404 File Not Fount\r\n" +
                        "Content-Type: text/html\r\n" +
                        "\r\n" +
                        "<h1>File Not Found</h1>";
                output.write(errorMesssage.getBytes());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                fis.close();
            }
        }
    }
}
