package service;

import dao.OrderDao;
import dao.OrderDetailDao;
import entity.Customers;
import entity.Employees;
import entity.Orders;
import entity.OrdersDetail;
import sun.net.ConnectionResetException;
import until.DBHelper;

import javax.persistence.criteria.Order;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private OrderDao od;
    private OrderDetailDao odd;

    public OrderService() {
        od = new OrderDao();
        odd=new OrderDetailDao();

    }
      public List<Orders> findAllOrders() {
          List<Orders> list = new ArrayList<Orders>();
          Connection conn = null;
          try {
              conn = DBHelper.getConnection();
              ResultSet set = od.selectAllOrders(conn);
              while (set.next()) {
                  String orderID = set.getString("orderID");
                  String order_date = set.getString("order_date");
                  int customerID = set.getInt("customerID");
                  String customer_name=set.getString("customer_name");

                  int empID = set.getInt("empID");
                  String emp_name=set.getString("emp_name");


                  list.add(new Orders(orderID,order_date, new Employees(empID,emp_name), new Customers(customerID,customer_name)));
              }
          } catch (SQLException e) {
              e.printStackTrace();
          } finally {
              od.close();
          }

          return list;
      }
   public boolean addOrder(Orders orders, List<OrdersDetail> list) throws SQLException {
       Connection conn=DBHelper.getConnection();
        int i=0;
        int[] arr=null;
        try{
            conn.setAutoCommit(false);
            i=od.insertOrders(conn,orders);
            if(i>0){
                arr=odd.insertDetails(conn,list);
            }
            conn.commit();
            conn.setAutoCommit(true);
        }catch (SQLException e){
            try{
                conn.rollback();
                conn.setAutoCommit(true);
            }catch (SQLException e1){
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        if(arr.length>0){
            return true;
        }
        return false;
   }
}

