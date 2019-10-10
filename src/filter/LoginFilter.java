package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("登陆过滤器初始化了~~~~~~~~");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        HttpSession session=request.getSession();
        String uri=request.getRequestURI();
        Object loginName=session.getAttribute("loginName");

        if(uri.indexOf("login")==-1&&uri.indexOf("css")==-1&&uri.indexOf("javascript")==-1&&uri.indexOf("ser")==-1&&uri.indexOf("regist")==-1&&uri.indexOf("img")==-1&&uri.indexOf("time")==-1&&uri.indexOf("Regist")==-1) {
            if (loginName == null) {
                PrintWriter out=servletResponse.getWriter();
                out.write("<script>alert('对不起，请先登录');location.href='"+request.getContextPath()+"/login.jsp';</script>");
            } else {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        }else{
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
        System.out.println("登陆过滤器销毁了~~~~~~~~");
    }
}
