package servlet;

import com.google.gson.Gson;
import entity.Categorys;
import entity.Products;
import entity.Providers;
import service.CategoryServiceImp;
import service.ProductServiceImp;
import service.ProviderServiceImp;
import until.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/Products")
public class ProductServlet extends HttpServlet {
    ProductServiceImp ps = new ProductServiceImp();
    private static final long serialVersionUID = 1L;

    public ProductServlet() {
        ps = new ProductServiceImp();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     /*   request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");*/
        String op = request.getParameter("op");
        System.out.println("op:" + op + "----------productServlet-----------");
        if ("doShowAll".equals(op)) {
            doShowAll(request, response);
        } else if ("doDelete".equals(op)) {
            doDelete(request, response);
        } else if ("doShowPage".equals(op)) {
            doShowPage(request, response);
        } else if ("ready".equals(op)) {
            ready(request, response);
        } else if ("doEdit".equals(op)){
            doEdit(request, response);
        } else if("doAdd".equals(op)){
            doAdd(request, response);
        }else if("readyto".equals(op)){
            readyto(request, response);
        }else if("addToCar".equals(op)){
            addToCar(request, response);
        }else if("doShowCar".equals(op)){
            doShowCar(request, response);
        }else if("doDeleteCar".equals(op)){
            doDeleteCar(request,response);
        }else if("checkName".equals(op)){
            checkName(request,response);
        }else if("cateAndPros".equals(op)){
            cateAndPros(request,response);
        }else if("cateAndPros2".equals(op)){
            cateAndPros2(request,response);
        }

}
    protected void checkName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         int id=Integer.parseInt(request.getParameter("id"));
         String name=request.getParameter("name");
          Products f=ps.findProductsRecord(new Products(id,name));
         PrintWriter out=response.getWriter();
         if(f!=null){
             out.print("重名");
         }else{
             out.print("可用");
         }
    }
    protected void doDeleteCar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=request.getParameter("pid");
        System.out.println(id);
        Cookie c=new Cookie("goods-"+id,id);
        c.setMaxAge(0);
        response.addCookie(c);
        List<Products> list=ps.findAllProducts();
        request.setAttribute("list",list);
     request.getRequestDispatcher("ShowAllProducts.jsp").forward(request,response);

    }
    protected void doShowCar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      ArrayList<String> ids=new ArrayList<String>();
       Cookie[] arr= request.getCookies();
       if(arr!=null){
           for(Cookie c:arr) {
               if (("goods-" + c.getValue()).equals(c.getName())) {
                   ids.add(c.getValue());
                   System.out.println("++++++++++++"+c.getName());
               }
           }
       }
        List<Products> lists=new ArrayList<Products>();
       for(String id:ids){
       int id1=Integer.parseInt(id);
        Products products=ps.findAllById(id1);
           lists.add(products);
       }

        request.setAttribute("lists",lists);
       request.getRequestDispatcher("shoppingCar.jsp").forward(request,response);
    }
    protected void addToCar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          String id=request.getParameter("pid");
        System.out.println(id);
          Cookie c=new Cookie("goods-"+id,id);
          c.setMaxAge(60*60*24*7);
          response.addCookie(c);
          PrintWriter out=response.getWriter();
          out.write("<script>history.back();</script>");
    }

    protected void doShowAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Products> list=ps.findAllProducts();
        Gson gson=new Gson();
        String json=gson.toJson(list);
        response.getWriter().print(json);
       /* request.setAttribute("list",list);

        request.getRequestDispatcher("ShowAllProducts.jsp").forward(request,response);*/
    }
    protected void doShowPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String product_name=request.getParameter("product_name");
        int providerID=Integer.parseInt(request.getParameter("providerID"));

        int categoryID=Integer.parseInt(request.getParameter("categoryID"));
        int currentPage=Integer.parseInt(request.getParameter("currentPage"));
       int pageSize=Integer.parseInt(request.getParameter("pageSize"));
       Page<Products> page=ps.selectProductByCondition(new Products(product_name,new Providers(providerID),new Categorys(categoryID)),
               new Page<Products>(currentPage,pageSize));

       Gson gson=new Gson();
       String json=gson.toJson(page);
       response.getWriter().print(json);


    }
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("pid"));
        int i = ps.subProductsById(id);
        PrintWriter out = response.getWriter();
        if (i > 0) {
            out.print("ok");
        } else {
            out.print("no");
        }
    }
    protected void ready(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("pid"));
        Products p=ps.findProductsByproductId(id);
        ProviderServiceImp psi=new ProviderServiceImp();
        ArrayList<Providers> list1= (ArrayList<Providers>) psi.findAllProviders();
        CategoryServiceImp cs=new CategoryServiceImp();
        List<Categorys> list2=cs.findAllCategorys();

        request.setAttribute("pid",id);

        request.setAttribute("p",p);
        request.setAttribute("list1",list1);
        request.setAttribute("list2",list2);

        request.getRequestDispatcher("editProducts.jsp").forward(request,response);

    }
    //得到所有供应商和种类
    protected void cateAndPros(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProviderServiceImp psi=new ProviderServiceImp();
        ArrayList<Providers> list1= (ArrayList<Providers>) psi.findAllProviders();
        CategoryServiceImp cs=new CategoryServiceImp();
        List<Categorys> list2=cs.findAllCategorys();

        String pid=request.getParameter("pid");
        Products p=ps.findProductsByproductId(Integer.parseInt(pid));

        Object[] arr={list1,list2,p};
        Gson gson=new Gson();
        String json=gson.toJson(arr);
        response.getWriter().print(json);
    }
    protected void cateAndPros2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProviderServiceImp psi=new ProviderServiceImp();
        ArrayList<Providers> list1= (ArrayList<Providers>) psi.findAllProviders();
        CategoryServiceImp cs=new CategoryServiceImp();
        List<Categorys> list2=cs.findAllCategorys();


        Object[] arr={list1,list2};
        Gson gson=new Gson();
        String json=gson.toJson(arr);
        response.getWriter().print(json);
    }
    protected void readyto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ProviderServiceImp psi=new ProviderServiceImp();
        ArrayList<Providers> list1= (ArrayList<Providers>) psi.findAllProviders();
        CategoryServiceImp cs=new CategoryServiceImp();
        List<Categorys> list2=cs.findAllCategorys();
        request.setAttribute("list1",list1);
        request.setAttribute("list2",list2);
        request.getRequestDispatcher("addProducts.jsp").forward(request,response);

    }
    protected void doAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String product_name=request.getParameter("product_name");
        double income_price=Double.parseDouble(request.getParameter("income_price"));
        int quantity=Integer.parseInt(request.getParameter("quantity"));
        double sale_price=Double.parseDouble(request.getParameter("sale_price"));
        int providerID=Integer.parseInt(request.getParameter("pro"));
        int categoryID=Integer.parseInt(request.getParameter("cate"));
        String income_time=request.getParameter("income_time");

        PrintWriter out=response.getWriter();
        Products pname=ps.findProductsRecord(product_name);
        if(pname!=null){
            out.print("<script language='javascript'>alert('产品名已存在');location.href='Products?op=readyto';</script>");
        }else{
            Providers providers=new Providers(providerID);
            Categorys categorys=new Categorys(categoryID);
            Products products=new Products(product_name,income_price,providers,quantity,sale_price,categorys,income_time);

            ps.addProducts(products);
            out.print("<script language='javascript'>alert('增加成功');location.href='Products?op=doShowAll';</script>");
        }
    }
    protected void doEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productID=Integer.parseInt(request.getParameter("productID"));
        String product_name=request.getParameter("product_name");
        double income_price=Double.parseDouble(request.getParameter("income_price"));
        int quantity=Integer.parseInt(request.getParameter("quantity"));
        double sale_price=Double.parseDouble(request.getParameter("sale_price"));
        int providerID=Integer.parseInt(request.getParameter("pro"));
        int categoryID=Integer.parseInt(request.getParameter("cate"));
        String income_time=request.getParameter("income_time");
        PrintWriter out=response.getWriter();
        Products pname=ps.findProductsRecord(product_name);
        if(pname!=null&&pname.getProductID()!=productID){
            out.print("<script language='javascript'>alert('产品名已存在');location.href='Products?op=ready&pid="+productID+"';</script>");
        }
        else{
            Providers providers=new Providers(providerID);
            Categorys categorys=new Categorys(categoryID);
            Products products=new Products(productID,product_name,income_price,providers,quantity,sale_price,categorys,income_time);
            ps.chagneProducts(products);
            out.print("<script language='javascript'>alert('修改成功');location.href='Products?op=doShowAll';</script>");
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
