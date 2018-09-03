package com.pinyougou.sellergoods.service;

import java.util.List;

import com.pinyougou.pojo.TbBrand;

import entity.PageResult;

/*
 * 
 * 品牌接口
 */
public interface BrandService {
	
	/**查出所有品牌
	 * @return
	 */
	public List<TbBrand> queryAll();
	//刷新页面的查询
	public PageResult queryPage(int pageNum,int pageSize);
	//添加
	public void add(TbBrand dto); 
	//修改
	public void update(TbBrand dto);
	//用于修改的查询
	public TbBrand queryOne(long id);
	//删除
	public void delete(long[] ids);
	//条件查询，重载queryPage
	public PageResult queryPage(TbBrand dto,int pageNum,int pageSize);
	

}
