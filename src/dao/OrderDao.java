package dao;

import entity.Orders;
import entity.OrdersDetail;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OrderDao extends  BaseDao {
    //增
    public int insertOrders(Connection conn, Orders orders) throws SQLException {
        String sql = "insert into orders (orderID,order_date,customerID,empID) values(?,?,?,?)";
        return super.updateDate(conn, sql, orders.getOrderID(), orders.getOrder_date(),
                orders.getCus(), orders.getEmp());
    }

        //删
        //改
        //查
    public ResultSet selectAllOrders(Connection conn) throws SQLException {
            String sql="select o.*,cus.customerID,cus.customer_name,emp.empID,emp.emp_name from orders o,customers cus,employees emp where o.customerID=cus.customerID and o.empID=emp.empID";
            return super.selectDate(conn,sql,null);
        }

}
