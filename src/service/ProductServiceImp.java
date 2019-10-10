package service;

import dao.ProductDaoImp;
import entity.Categorys;
import entity.Products;
import entity.Providers;
import until.DBHelper;
import until.Page;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceImp implements ProductService {
	private ProductDaoImp pd;

	public ProductServiceImp() {
		pd = new ProductDaoImp();

	}

	@Override
	public int getConditionRecord(Products products) {
		return 0;
	}

	@Override
	public Page<Products> selectProductByCondition(Products products, Page<Products> page) {
		ArrayList<Products> list = new ArrayList<Products>();
		int totalRecord=0;
		Connection conn = null;
		try {
			conn = DBHelper.getConnection();
			totalRecord = pd.getConditionRecord(conn,products);
			ResultSet set = pd.selectProductByCondition(conn,products,page);

			while (set.next()) {
				int productID = set.getInt("productID");
				String product_name = set.getString("product_name");
				double income_price = set.getDouble("income_price");

				int providerID = set.getInt("providerID");
				String provider_name = set.getString("provider_name");
				int quantity = set.getInt("quantity");
				double sales_price = set.getDouble("sales_price");

				int categoryID = set.getInt("categoryID");
				String category_name = set.getString("category_name");
				String income_time = set.getString("income_time");

				list.add(new Products(productID, product_name, income_price, new Providers(providerID, provider_name),
						quantity, sales_price, new Categorys(categoryID, category_name), income_time));
			}
			page.setList(list);

			page.setTotalRecord(totalRecord);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pd.close();
		}

		return page;
	}


	@Override
	public List<Products> findAllProducts() {
		List<Products> list = new ArrayList<Products>();
		Connection conn = null;
		try {
			conn = DBHelper.getConnection();
			ResultSet set = pd.selectAllProduct(conn);
			while (set.next()) {
				int productID = set.getInt("productID");
				String product_name = set.getString("product_name");
				double income_price = set.getDouble("income_price");

				int providerID = set.getInt("providerID");
				String provider_name = set.getString("provider_name");
				int quantity = set.getInt("quantity");
				double sales_price = set.getDouble("sales_price");

				int categoryID = set.getInt("categoryID");
				String category_name = set.getString("category_name");
				String income_time = set.getString("income_time");

				list.add(new Products(productID, product_name, income_price, new Providers(providerID, provider_name),
						quantity, sales_price, new Categorys(categoryID, category_name), income_time));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pd.close();
		}

		return list;
	}

	@Override
	public Products findAllById(int id) {
		Connection conn = null;
		try {
			conn = DBHelper.getConnection();
			ResultSet set = pd.selectAllById(conn, id);
			if (set.next()) {
				int productID = set.getInt("productID");
				String product_name = set.getString("product_name");
				double income_price = set.getDouble("income_price");
				int providerID = set.getInt("providerID");
				String provider_name = set.getString("provider_name");
				int quantity = set.getInt("quantity");
				double sales_price = set.getDouble("sales_price");
				int categoryID = set.getInt("categoryID");
				String category_name = set.getString("category_name");
				String income_time = set.getString("income_time");

				return new Products(productID, product_name, income_price, new Providers(providerID, provider_name), quantity,
						sales_price, new Categorys(categoryID, category_name), income_time);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public Page<Products> findProductByPage(Page<Products> page) {
		List<Products> list = new ArrayList<Products>();
		Connection conn = null;
		try {
			conn = DBHelper.getConnection();
			ResultSet set = pd.selectProductsByPage(conn, page);
			int totalRecord = pd.getTotalRecord(conn);
			while (set.next()) {
				int productID = set.getInt("productID");
				String product_name = set.getString("product_name");
				double income_price = set.getDouble("income_price");

				int providerID = set.getInt("providerID");
				String provider_name = set.getString("provider_name");
				int quantity = set.getInt("quantity");
				double sales_price = set.getDouble("sales_price");

				int categoryID = set.getInt("categoryID");
				String category_name = set.getString("category_name");
				String income_time = set.getString("income_time");

				list.add(new Products(productID, product_name, income_price, new Providers(providerID, provider_name),
						quantity, sales_price, new Categorys(categoryID, category_name), income_time));
			}
			page.setList(list);

			page.setTotalRecord(totalRecord);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pd.close();
		}

		return page;
	}

	@Override
	public int getTotalRecord() {
		try {
			Connection conn = DBHelper.getConnection();
			return pd.getTotalRecord(conn);
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public Products findProductsRecord(String name) {
		Connection conn = null;
		try {
			conn = DBHelper.getConnection();
			ResultSet set = pd.selectProductsRecord(conn, name);
			if (set.next()) {
				int productID = set.getInt("productID");
				String product_name = set.getString("product_name");
				double income_price = set.getDouble("income_price");
				int providerID = set.getInt("providerID");
				int quantity = set.getInt("quantity");
				double sales_price = set.getDouble("sales_price");
				int categoryID = set.getInt("categoryID");
				String income_time = set.getString("income_time");
				return new Products(productID, product_name, income_price, new Providers(providerID), quantity,
						sales_price, new Categorys(categoryID), income_time);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void chagneProducts(Products products) {
		Connection conn = null;
		try {
			conn = DBHelper.getConnection();
			int i = pd.updateProducts(conn, products);
			if (i == 1) {
				System.out.println("修改成功");
			} else {
				System.out.println("修改失败");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pd.close();
		}

	}

	@Override
	public void addProducts(Products products) {
		Connection conn = null;
		try {
			conn = DBHelper.getConnection();
			int i = pd.insertProducts(conn, products);
			if (i == 1) {
				System.out.println("增加产品成功");
			} else {
				System.out.println("增加失败");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pd.close();
		}
	}

	@Override
	public int subProductsById(int id) {
		Connection conn = null;
		try {
			conn = DBHelper.getConnection();
			int i = pd.deleteProductsById(conn, id);
			if (i == 1) {
				return 1;
			} else {
				return -1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pd.close();
		}
        return 0;
	}

	@Override
	public Products findProductsByproviderId(int id) {
		Connection conn = null;
		try {
			conn = DBHelper.getConnection();
			ResultSet set = pd.selectProductsByproviderId(conn, id);
			if (set.next()) {
				int productID = set.getInt("productID");
				String product_name = set.getString("product_name");
				double income_price = set.getDouble("income_price");
				int providerID = set.getInt("providerID");
				int quantity = set.getInt("quantity");
				double sales_price = set.getDouble("sales_price");
				int categoryID = set.getInt("categoryID");
				String income_time = set.getString("income_time");
				return new Products(productID, product_name, income_price, new Providers(providerID), quantity,
						sales_price, new Categorys(categoryID), income_time);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Products findProductsByproductId(int id) {
		Connection conn = null;
		try {
			conn = DBHelper.getConnection();
			ResultSet set = pd.selectProductsByproductId(conn, id);
			if (set.next()) {
				int productID = set.getInt("productID");
				String product_name = set.getString("product_name");
				double income_price = set.getDouble("income_price");
				int providerID = set.getInt("providerID");
				int quantity = set.getInt("quantity");
				double sales_price = set.getDouble("sales_price");
				int categoryID = set.getInt("categoryID");
				String income_time = set.getString("income_time");
				return new Products(productID, product_name, income_price, new Providers(providerID), quantity,
						sales_price, new Categorys(categoryID), income_time);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Products findProductsBycategoryId(int id) {
		Connection conn = null;
		try {
			conn = DBHelper.getConnection();
			ResultSet set = pd.selectProductsBycategoryId(conn, id);
			if (set.next()) {
				int productID = set.getInt("productID");
				String product_name = set.getString("product_name");
				double income_price = set.getDouble("income_price");
				int providerID = set.getInt("providerID");
				int quantity = set.getInt("quantity");
				double sales_price = set.getDouble("sales_price");
				int categoryID = set.getInt("categoryID");
				String income_time = set.getString("income_time");
				return new Products(productID, product_name, income_price, new Providers(providerID), quantity,
						sales_price, new Categorys(categoryID), income_time);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Products findProductsRecord(String name, int id) {
		Connection conn = null;
		try {
			conn = DBHelper.getConnection();
			ResultSet set = pd.selectProductsRecord2(conn, name, id);
			if (set.next()) {
				int productID = set.getInt("productID");
				String product_name = set.getString("product_name");
				double income_price = set.getDouble("income_price");
				int providerID = set.getInt("providerID");
				int quantity = set.getInt("quantity");
				double sales_price = set.getDouble("sales_price");
				int categoryID = set.getInt("categoryID");
				String income_time = set.getString("income_time");
				return new Products(productID, product_name, income_price, new Providers(providerID), quantity,
						sales_price, new Categorys(categoryID), income_time);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pd.close();
		}

		return null;
	}

	public Products findProductsRecord(Products products) {
		Connection conn = null;
		try {
			conn = DBHelper.getConnection();
			ResultSet set = pd.selectProductsRecord2(conn, products);
			if (set.next()) {
				int productID = set.getInt("productID");
				String product_name = set.getString("product_name");

				return new Products(productID, product_name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pd.close();
		}
		return null;
	}
}