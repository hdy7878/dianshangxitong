package service;

import dao.EmployeeDao;
import entity.Employees;
import until.DBHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService {
    private EmployeeDao ed;
    public EmployeeService(){
        ed=new EmployeeDao();
    }
public List<Employees> findAllEmployees(){
    ArrayList<Employees> list=new ArrayList<Employees>();
    Connection conn = null;
    try {
        conn = DBHelper.getConnection();
        ResultSet set = ed.selectAllEmployees(conn);
        while (set.next()) {
            int empID=set.getInt("empID");
            String emp_name = set.getString("emp_name");
            String hire_date = set.getString("hire_date");
            double salary = set.getDouble("salary");

            list.add(new Employees(empID,emp_name,hire_date,salary));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        ed.close();
    }

    return list;
}
}

