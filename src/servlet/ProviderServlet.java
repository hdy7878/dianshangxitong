package servlet;

import entity.Providers;
import service.ProviderServiceImp;
import until.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/Providers")
public class ProviderServlet extends HttpServlet {
    ProviderServiceImp pvs=new ProviderServiceImp();

    private static final long serialVersionUID=1L;
    public ProviderServlet(){
        pvs=new ProviderServiceImp();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    /*    request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");*/

        String op=request.getParameter("op");
        System.out.println("op:"+op+"----------providerServlet-----------");
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
        }

    }

    protected void ready(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         int id=Integer.parseInt(request.getParameter("pvid"));
         Providers pv=pvs.findProvidersRecord(id);
         List<Providers> list=pvs.findAllProviders();
         request.setAttribute("pv",pv);
         request.setAttribute("list",list);
         request.getRequestDispatcher("editProviders.jsp").forward(request,response);
    }
    protected void doEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          int providerID=Integer.parseInt(request.getParameter("providerID"));
          String provider_name=request.getParameter("provider_name");
          String provider_add=request.getParameter("provider_add");
          String provider_tel=request.getParameter("provider_tel");
          String account=request.getParameter("account");
          String email=request.getParameter("email");
          PrintWriter out=response.getWriter();
          Providers pvname=pvs.findProvidersRecord(provider_name);
          if(pvname!=null&&pvname.getProviderID()!=providerID){
              out.print("<script>alert('该供应商已经存在');location.href='Providers?op=ready&pvid="+providerID+"'</script>");
          }else{
              Providers providers=new Providers(providerID,provider_name,provider_add,provider_tel,account,email);
              pvs.chagneProviders(providers);
              out.print("<script>alert('修改成功');location.href='Providers?op=doShowAll'</script>");
          }

    }
    protected void readyto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProviderServiceImp pvs=new ProviderServiceImp();
        List<Providers> list=pvs.findAllProviders();
        request.setAttribute("list",list);
        request.getRequestDispatcher("addProviders.jsp").forward(request,response);
    }
    protected void doAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       /*得到字段*/
        String provider_name=request.getParameter("provider_name");
        String provider_add=request.getParameter("provider_add");
        String provider_tel=request.getParameter("provider_tel");
        String account=request.getParameter("account");
        String eamil=request.getParameter("email");
        /*得到一个输出流*/
        PrintWriter out=response.getWriter();
        /*调用方法检测是否有重名*/
        Providers pvname=pvs.findProvidersRecord(provider_name);
        if(pvname!=null){
            out.print("<script language='javascript'>alert('该供应商已经存在');location.href='Providers?op=readyto';</script>");
        }else{
            Providers providers=new Providers(provider_name,provider_add,provider_tel,account,eamil);
            pvs.addProviders(providers);
            out.print("<script language='javascript'>alert('增加成功');location.href='Providers?op=doShowAll';</script>");
        }
    }


    protected void doShowAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Providers> list=pvs.findAllProviders();
        request.setAttribute("list",list);
        request.getRequestDispatcher("ShowAllProviders.jsp").forward(request,response);
    }
    protected void doShowPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int currentPage=Integer.parseInt(request.getParameter("currentPage"));
        int pageSize=Integer.parseInt(request.getParameter("pageSize"));
        Page<Providers> page= pvs.fingProvidersByPage(new Page<Providers>(currentPage,pageSize));
        request.setAttribute("page",page);
        request.getRequestDispatcher("ShowAllPvPage.jsp").forward(request,response);
    }
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("pvid"));
        pvs.subProvidersById(id);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
