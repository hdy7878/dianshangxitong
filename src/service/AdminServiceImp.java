package service;

import dao.AdminDaoImp;
import entity.Admin;
import until.DBHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminServiceImp implements AdminService {
	private AdminDaoImp ad;

	public AdminServiceImp() {
		ad = new AdminDaoImp();
	}

	@Override
	public Admin findAdminByLogin(Admin admin) {
		Connection conn = null;
		try {
			conn = DBHelper.getConnection();
			ResultSet set = ad.selectAdminByLogin(conn, admin);
			if (set.next()) {
				int admin_id = set.getInt("admin_id");
				String admin_name = set.getString("admin_name");
				String admin_password = set.getString("admin_password");
				return new Admin(admin_id, admin_name, admin_password);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("你来呀，错误我不怕");
		} finally {
			ad.close();
		}
		return null;
	}

	@Override
	public int addAdmin(Admin admin) {
		Connection conn = null;

		try {
			conn = DBHelper.getConnection();
			int a = ad.insertAdmin(conn, admin);
			return a;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ad.close();
		}
    return 0;
	}

	@Override
	public Admin findAdminRecord(String name) {
		Connection conn = null;
		try {
			conn = DBHelper.getConnection();
			ResultSet set = ad.selectAdminRecord(conn, name);
			if (set.next()) {
				int admin_id = set.getInt("admin_id");
				String admin_name = set.getString("admin_name");
				String admin_password = set.getString("admin_password");
				return new Admin(admin_id, admin_name, admin_password);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ad.close();
		}
		return null;
	}

	@Override
	public Admin changeAdmin() {

		return null;
	}

	@Override
	public Admin subAdminById() {

		return null;
	}

	@Override
	public Admin findAdminByPage() {

		return null;
	}
}