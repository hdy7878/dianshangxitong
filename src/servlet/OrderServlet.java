package servlet;


import com.google.gson.Gson;
import entity.Customers;
import entity.Employees;
import entity.Orders;
import entity.Products;
import service.CustomerService;
import service.EmployeeService;
import service.OrderService;
import service.ProductServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet(urlPatterns = "/Orders")
public class OrderServlet extends HttpServlet {
    OrderService os = new OrderService();
    private static final long serialVersionUID = 1L;

    public OrderServlet() {
        os = new OrderService();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String op = request.getParameter("op");
        System.out.println("op:" + op + "----------orderServlet-----------");
        if ("doShowAll".equals(op)) {
            doShowAll(request, response);
        } else if ("doDelete".equals(op)) {
            doDelete(request, response);
        }else if("doAdd".equals(op)){
            doAdd(request, response);
        }else if("readyto".equals(op)){
            readyto(request, response);
        }else if("doShowDetail".equals(op)){
            doShowDetail(request,response);
        }
    }
    protected void doShowDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
    protected void doAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       /* String orderID=request.getParameter("orderID");
        String order_date=request.getParameter("order_date");
        int customerID=Integer.parseInt(request.getParameter("customerID"));
        int empID=Integer.parseInt(request.getParameter("empID"));

        Orders orders=new Orders(orderID,order_date, new Employees(empID), new Customers(customerID));
        String[] pids=request.getParameterValues("productID");
        String[] nums=request.getParameterValues("quantity");
        String[] dis=request.getParameterValues("discount");

        ArrayList<OrdersDetail> list=new ArrayList<OrdersDetail>();
        for(int i=0;i<pids.length;i++){

        } */
    }
    protected void readyto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orderID= UUID.randomUUID().toString().replace("-","");
        CustomerService css=new CustomerService();
        List<Customers> list1=css.findAllCustomers();
        EmployeeService ems=new EmployeeService();
        List<Employees> list2 =ems.findAllEmployees();
        ProductServiceImp ps=new ProductServiceImp();
        List<Products> list3=ps.findAllProducts();
       Object[] arr={orderID,list1,list2,list3};
        Gson gson=new Gson();
        String str=gson.toJson(arr);
        response.getWriter().print(str);

    }
    protected void doShowAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Orders> list=os.findAllOrders();

        request.setAttribute("list",list);
        request.getRequestDispatcher("ShowAllOrders.jsp").forward(request,response);
    }
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
