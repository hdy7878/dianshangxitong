package dao;

import entity.Products;
import until.Page;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDaoImp extends BaseDao implements ProductDao {

	@Override
	public ResultSet selectProductsByPage(Connection conn, Page<Products> page) throws SQLException {
		String sql = "select p.*,cg.category_name,pv.provider_name from products p,categorys cg,providers pv where p.categoryID=cg.categoryID and p.providerID=pv.providerID order by p.productID asc limit ?,?";
		Object[] objects = { (page.getCurrentPage() - 1) * page.getPageSize(), page.getPageSize() };

		return super.selectDate(conn, sql, objects);
	}


	@Override
	public int getConditionRecord(Connection conn, Products products) throws SQLException {
      String sql="select count(p.productID) from products p where 1=1";
		ArrayList list=new ArrayList();
		if(products.getProduct_name()!=null&&!products.getProduct_name().equals("")){
			sql+=" and p.product_name like ?";
			list.add("%"+products.getProduct_name()+"%");
		}
		if(products.getPv().getProviderID()!=0){
			sql+=" and p.providerID=?";
			list.add(products.getPv().getProviderID());
		}
		if(products.getCg().getCategoryID()!=0){
			sql+=" and p.categoryID=?";
			list.add(products.getCg().getCategoryID());
		}
		ResultSet set=super.selectDate(conn,sql,list.toArray());
        if(set.next()){
        	return set.getInt(1);
		}
      return 0;
	}

	@Override
	public ResultSet selectProductByCondition(Connection conn, Products products, Page<Products> page) throws SQLException {
      String sql="select p.*,cg.category_name,pv.provider_name from products p,categorys cg,providers pv where p.categoryID=cg.categoryID and p.providerID=pv.providerID";
	ArrayList list=new ArrayList();
      if(products.getProduct_name()!=null&&!products.getProduct_name().equals("")){
			sql+=" and p.product_name like ?";
			list.add("%"+products.getProduct_name()+"%");
		}
		if(products.getPv().getProviderID()!=0){
			sql+=" and p.providerID=?";
			list.add(products.getPv().getProviderID());
		}
		if(products.getCg().getCategoryID()!=0){
			sql+=" and p.categoryID=?";
			list.add(products.getCg().getCategoryID());
		}

        sql+=" order by p.productID asc limit ?,?";
		list.add((page.getCurrentPage() - 1) * page.getPageSize());
		list.add(page.getPageSize());
		return super.selectDate(conn,sql,list.toArray());
	}

	@Override
	public ResultSet selectAllById(Connection conn, int id) throws SQLException {
		String sql = "select p.*,cg.category_name,pv.provider_name from products p,categorys cg,providers pv where p.categoryID=cg.categoryID and p.providerID=pv.providerID and productID=? order by p.productID asc";
	 return super.selectDate(conn,sql,id);
	}

	@Override
	public ResultSet selectAllProduct(Connection conn) throws SQLException {
		String sql = "select p.*,cg.category_name,pv.provider_name from products p,categorys cg,providers pv where p.categoryID=cg.categoryID and p.providerID=pv.providerID order by p.productID asc";
		return super.selectDate(conn, sql, null);
	}

	@Override
	public int getTotalRecord(Connection conn) throws SQLException {
		String sql = "select count(productID) from products";
		ResultSet set = super.selectDate(conn, sql, null);
		if (set.next()) {
			return set.getInt(1);
		}
		return 0;
	}

	@Override
	public int updateProducts(Connection conn, Products products) throws SQLException {
		String sql = "update products set product_name=?,income_price=?,providerID=?,quantity=?,sales_price=?,categoryID=?,income_time=? where productID=?";

		return super.updateDate(conn, sql, products.getProduct_name(), products.getIncome_price(),
				products.getPv().getProviderID(), products.getQuantity(), products.getSale_price(),
				products.getCg().getCategoryID(),products.getIncome_time(),products.getProductID());
	}

	@Override
	public ResultSet selectProductsRecord(Connection conn, String name) throws SQLException {
		String sql = "select * from products where product_name=?";
		return super.selectDate(conn, sql, name);
	}

	@Override
	public int insertProducts(Connection conn, Products products) throws SQLException {
		String sql = "insert into products (product_name,income_price,providerID,quantity,sales_price,categoryID,income_time) values(?,?,?,?,?,?,?)";
		return super.updateDate(conn, sql, products.getProduct_name(), products.getIncome_price(),
				products.getPv().getProviderID(), products.getQuantity(), products.getSale_price(),
				products.getCg().getCategoryID(),products.getIncome_time());

	}

	@Override
	public int deleteProductsById(Connection conn, int id) throws SQLException {
		String sql = "delete from products where productID = ?";
		return super.updateDate(conn, sql, id);
	}

	@Override
	public ResultSet selectProductsByproviderId(Connection conn, int id) throws SQLException {
		String sql = "select * from products where providerID=?";
		return super.selectDate(conn, sql, id);
	}

	@Override
	public ResultSet selectProductsBycategoryId(Connection conn, int id) throws SQLException {
		String sql = "select * from products where categoryID=?";
		return super.selectDate(conn, sql, id);
	}

	@Override
	public ResultSet selectProductsByproductId(Connection conn, int id) throws SQLException {
		String sql = "select * from products where productID=?";
		return super.selectDate(conn, sql, id);
	}

	@Override
	public ResultSet selectProductsRecord2(Connection conn, String name, int id) throws SQLException {
		String sql = "select * from products where product_name=? and productID!=?";
		return super.selectDate(conn, sql, name, id);
	}

	public ResultSet selectProductsRecord2(Connection conn, Products products) throws SQLException {
		String sql = "select * from products where product_name=? and productID!=?";
		return super.selectDate(conn, sql, products.getProduct_name(),products.getProductID());
	}
}
