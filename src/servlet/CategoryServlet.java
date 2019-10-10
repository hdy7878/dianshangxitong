package servlet;

import entity.Categorys;
import service.CategoryServiceImp;
import until.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/Categorys")
public class CategoryServlet extends HttpServlet {
    CategoryServiceImp cs=new  CategoryServiceImp();

    private static final long serialVersionUID=1L;
    public CategoryServlet(){
        cs=new CategoryServiceImp();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");*/

        String op=request.getParameter("op");
        System.out.println("op:"+op+"----------CategoryServlet-----------");
        if("doShowAll".equals(op)){
            doShowAll(request,response);
        }else if ("doDelete".equals(op)){
            doDelete(request, response);
        }else if("doShowPage".equals(op)){
            doShowPage(request, response);
        }else if ("ready".equals(op)) {
            ready(request, response);
        } else if ("doEdit".equals(op)){
            doEdit(request, response);
        } else if("doAdd".equals(op)){
            doAdd(request, response);
        }else if("readyto".equals(op)){
            readyto(request, response);
        }else if("checkName".equals(op)){
            checkName(request,response);
        }
    }
    private void checkName(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

        String category_name=request.getParameter("category_name");
        /*category_name = new String(category_name.getBytes("iso8859-1"),"utf-8");*/

        Categorys categorys = cs.findCategorysRecord(category_name);
        System.out.println(category_name);
        if(categorys!=null){
            response.getWriter().print("false");
        }else{
            response.getWriter().print("true");
        }
    }


    private void readyto(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
      /*得到列表信息，跳转的时候一起带过去*/
        CategoryServiceImp cs=new CategoryServiceImp();
        List<Categorys> list=cs.findAllCategorys();
        request.setAttribute("list",list);
        request.getRequestDispatcher("addCategorys.jsp").forward(request,response);
    }

    private void doAdd(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException {
        /*得到种类的名字和介绍
         * */
        String category_name=request.getParameter("category_name");
        String category_desc=request.getParameter("category_desc");
        /*得到一个输出流*/
        PrintWriter out=response.getWriter();
        /*调用方法检测是否有重名*/
        Categorys cname=cs.findCategorysRecord(category_name);
        if(cname!=null){/*如果不为空，就说明重名了*/
            out.print("<script language='javascript'>alert('该种类已经存在');location.href='Categorys?op=readyto';</script>");
        }else{
            Categorys categorys=new Categorys(category_name,category_desc);
            cs.addCategorys(categorys);
            out.print("<script language='javascript'>alert('增加成功');location.href='Categorys?op=doShowAll';</script>");
        }

    }

    private void doEdit(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
           int categoryID=Integer.parseInt(request.getParameter("categoryID"));
           String category_name=request.getParameter("category_name");
           String category_desc=request.getParameter("category_desc");
           PrintWriter out=response.getWriter();
           Categorys cname=cs.findCategorysRecord(category_name);
           if(cname!=null&&cname.getCategoryID()!=categoryID){
               out.print("<script language='javascript'>alert('该种类已经存在');location.href='Categorys?op=ready&cid="+categoryID+"';</script>");
           }else{
               Categorys categorys=new Categorys(categoryID,category_name,category_desc);
               cs.changeCategorys(categorys);
               out.print("<script language='javascript'>alert('修改成功');location.href='Categorys?op=doShowAll';</script>");
           }
    }

    private void ready(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
         int id=Integer.parseInt(request.getParameter("cid"));
         Categorys cg=cs.findCategorysRecord(id);
         List<Categorys> list=cs.findAllCategorys();
        request.setAttribute("cg",cg);
         request.setAttribute("list",list);
         request.getRequestDispatcher("editCategorys.jsp").forward(request,response);
    }



    protected void doShowAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Categorys> list=cs.findAllCategorys();
        request.setAttribute("list",list);
        request.getRequestDispatcher("ShowAllCategorys.jsp").forward(request,response);
    }
    protected void doShowPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int currentPage=Integer.parseInt(request.getParameter("currentPage"));
        int pageSize=Integer.parseInt(request.getParameter("pageSize"));
        Page<Categorys> page= cs.fingCategorysByPage(new Page<Categorys>(currentPage,pageSize));
        request.setAttribute("page",page);
        request.getRequestDispatcher("ShowAllCPage.jsp").forward(request,response);
    }
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("cid"));
        cs.subCategorysById(id);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
