package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDao extends BaseDao{

        public ResultSet selectAllCustomers(Connection conn) throws SQLException {
            String sql="select * from customers";
            return super.selectDate(conn, sql);
    }
}
