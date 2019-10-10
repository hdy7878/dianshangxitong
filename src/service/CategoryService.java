package service;

import entity.Categorys;
import until.Page;

import java.util.List;

public interface CategoryService {
	// 查所有信息
	public List<Categorys> findAllCategorys();
	// 增
	public void addCategorys(Categorys categorys);
	// 查
	public Categorys findCategorysRecord(String name);

	// 查
	public Categorys findCategorysRecord(int id);

	// 查
	public Categorys findCategorysRecord(String name, int id);

	// 改
	public void changeCategorys(Categorys categorys);

	// 删
	public void subCategorysById(int id);

	// 分页查
	public Page<Categorys> fingCategorysByPage(Page<Categorys> page);

}
