import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName: PrimitiveServlet
 * +------------------------------------++
 * |     ex02.pyrmont包配套servlet类     ||
 * ====================================++
 * @Author: Yan Depeng
 * @Date: 2022/9/21 10:05
 * @Version: 1.0.0
 */
public class PrimitiveServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig)
            throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest,
                        ServletResponse servletResponse)
            throws ServletException, IOException {
        System.out.println("form service");
        PrintWriter out = servletResponse.getWriter();
        out.println("welcom to poortom");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
