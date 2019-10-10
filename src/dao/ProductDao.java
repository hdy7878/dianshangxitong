package dao;

import com.google.gson.internal.bind.SqlDateTypeAdapter;
import entity.Products;
import until.Page;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface ProductDao {
	//条件得到总记录数
	public int getConditionRecord(Connection conn,Products products)throws  SQLException;
	//根据条件查
	public ResultSet selectProductByCondition(Connection conn,Products products,Page<Products> page)throws SQLException;
	//根据id查所有信息
	public ResultSet selectAllById(Connection conn,int id)throws  SQLException;
	// 查所有信息
	public ResultSet selectAllProduct(Connection conn) throws SQLException;

	// 分页查信息
	public ResultSet selectProductsByPage(Connection conn, Page<Products> page) throws SQLException;

	// 得到所有记录
	public int getTotalRecord(Connection conn) throws SQLException;

	// 改
	public int updateProducts(Connection conn, Products products) throws SQLException;

	// 查
	public ResultSet selectProductsRecord(Connection conn, String name) throws SQLException;

	// 查
	public ResultSet selectProductsByproviderId(Connection conn, int id) throws SQLException;

	// 增
	public int insertProducts(Connection conn, Products products) throws SQLException;

	// 删
	public int deleteProductsById(Connection conn, int id) throws SQLException;

	// 查
	public ResultSet selectProductsBycategoryId(Connection conn, int id) throws SQLException;

	// 查
	public ResultSet selectProductsByproductId(Connection conn, int id) throws SQLException;

	// 查
	public ResultSet selectProductsRecord2(Connection conn, String name, int id) throws SQLException;
}