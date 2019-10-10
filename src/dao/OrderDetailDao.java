package dao;

import entity.OrdersDetail;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class OrderDetailDao extends  BaseDao {
    //多条增
    public int[] insertDetails(Connection conn, List<OrdersDetail> list) throws SQLException {
        String sql="insert into order_detail (orderID,p,quantity,discount) values(?,?,?,?)";
        Object[][] objs=new Object[list.size()][];
        for(int i=0;i<list.size();i++){
            objs[i]=new Object[]{list.get(i).getOrderID(),list.get(i).getP(),list.get(i).getQuantity(),list.get(i).getDiscount()};
        }
        return super.updateMore(conn,sql,objs);
    }
}
