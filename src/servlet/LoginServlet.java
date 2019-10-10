package servlet;

import entity.Admin;
import service.AdminServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet",urlPatterns = "/ser")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

}

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");*/
        String name= request.getParameter("username");
        String pass=request.getParameter("password");
        String time=request.getParameter("time");
        AdminServiceImp as=new AdminServiceImp();
        Admin admin=as.findAdminByLogin(new Admin(name,pass));
        PrintWriter out=response.getWriter();
       System.out.println(admin);

        if(admin!=null){

            Cookie[] arr=request.getCookies();
            for(Cookie cookie:arr){
                if("JSESSIONID".equals(cookie.getName())){
                    if(time!=null) {
                        if (time.equals("day")) {
                            cookie.setMaxAge(60 * 60 * 24);
                            response.addCookie(cookie);
                        } else if (time.equals("week")) {
                            cookie.setMaxAge(60 * 60 * 24 * 7);
                            response.addCookie(cookie);
                        } else if (time.equals("month")) {
                            cookie.setMaxAge(60 * 60 * 24 * 30);
                            response.addCookie(cookie);
                        }
                    }else{
                        cookie.setMaxAge(60 * 60);
                        response.addCookie(cookie);
                    }
                }
                }
            HttpSession session=request.getSession();
            session.setAttribute("loginName",name);
            out.write("<script>alert('恭喜登录成功啊'); location.href='main.jsp'</script>");
       }else{
            out.write("<script>alert('用户名密码错误'); history.back()</script>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
