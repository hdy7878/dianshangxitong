package service;

import dao.CustomerDao;
import entity.Customers;
import until.DBHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    private CustomerDao cd;
    public CustomerService(){
        cd=new CustomerDao();
    }
    public List<Customers> findAllCustomers() {
        List<Customers> list = new ArrayList<Customers>();
        Connection conn = null;
        try {
            conn = DBHelper.getConnection();
            ResultSet set = cd.selectAllCustomers(conn);
            while (set.next()) {
                int customerID=set.getInt("customerID");
                String customer_name = set.getString("customer_name");
                String customer_add = set.getString("customer_add");
                String customer_bir = set.getString("customer_bir");

                String customer_tel = set.getString("customer_tel");


                list.add(new Customers(customerID,customer_name,customer_add,customer_bir,customer_tel));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cd.close();
        }

        return list;
    }

}
