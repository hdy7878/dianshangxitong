package filter;

import javax.servlet.*;
import java.io.IOException;
import java.util.logging.LogRecord;

public class CharacterFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("字符过滤器初始化了~~~~~~~~");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        System.out.println("字符过滤器销毁了~~~~~~~~");
    }
}
