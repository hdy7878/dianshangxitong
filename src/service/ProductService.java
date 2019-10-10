package service;

import entity.Products;
import until.Page;

import java.util.List;

public interface ProductService {
	//得到所有记录
	public int getConditionRecord(Products products);
	//根据条件查询
	public Page<Products> selectProductByCondition(Products products, Page<Products> page);
	// 查所有信息
	public List<Products> findAllProducts();
	public Products findAllById(int id);

	// 分页查信息
	public Page<Products> findProductByPage(Page<Products> page);

	// 得到所有记录
	public int getTotalRecord();

	// 查
	public Products findProductsRecord(String name);

	// 查
	public Products findProductsRecord(String name, int id);

	// 查
	public Products findProductsByproviderId(int id);

	// 改
	public void chagneProducts(Products products);

	// 增
	public void addProducts(Products products);

	// 删
	public int subProductsById(int id);

	public Products findProductsByproductId(int id);

	public Products findProductsBycategoryId(int id);
}