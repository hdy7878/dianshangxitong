package dao;

import entity.Employees;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDao extends BaseDao {

    public ResultSet selectAllEmployees(Connection conn) throws SQLException {
        String sql="select * from employees";
        return super.selectDate(conn, sql);
    }
}
