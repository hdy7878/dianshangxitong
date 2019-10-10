package servlet;

import entity.Admin;
import service.AdminServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/Regist")
public class RegistServlet extends HttpServlet {
    AdminServiceImp as=new AdminServiceImp();

    private static final long serialVersionUID=1L;
    public RegistServlet(){
        as=new AdminServiceImp();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       /* request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");*/
        String op=request.getParameter("op");
        if("toLogin".equals(op)){
            toLogin(request, response);
        }else if("toRegist".equals(op)){
            toRegist(request,response);
        }else if("doAdd".equals(op)){
            doAdd(request,response);
        }



    }
    protected void doAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("username");
        String pass=request.getParameter("password");
        PrintWriter out=response.getWriter();
        Admin oldAdmin=as.findAdminRecord(name);
        if(oldAdmin!=null){
            out.print("<script language='javascript'>alert('用户名已存在');location.href='Regist?op=toLogin';</script>");
        }else{
            Admin admin=new Admin(name,pass);
            int i =as.addAdmin(admin);
            if(i==1){
                out.print("<script language='javascript'>alert('注册成功');location.href='Regist?op=toLogin';</script>");
            }else
            {
                out.print("<script language='javascript'>alert('注册失败');location.href='Regist?op=toLogin';</script>");
            }
        }

    }
    protected void toLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("login.jsp");
    }
    protected void toRegist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("regist.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
