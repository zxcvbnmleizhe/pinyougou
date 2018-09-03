package com.pinyougou.sellergoods.service.impl;

import java.util.List;

import org.aspectj.weaver.ast.And;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.TbBrandMapper;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.pojo.TbBrandExample;
import com.pinyougou.pojo.TbBrandExample.Criteria;
import com.pinyougou.sellergoods.service.BrandService;

import entity.PageResult;

@Service(timeout=10000)
public class BrandServiceImpl implements BrandService {

	@Autowired
	private TbBrandMapper mapper;
//	private TbBrandMapper mapper;
	
	
	@Override
	public List<TbBrand> queryAll() {
		// TODO Auto-generated method stub
		return mapper.selectByExample(null);
	}


	/* 实现分页
	 */
	@Override
	public PageResult queryPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		//List<TbBrand> selectByExample = mapper.selectByExample(null);
		Page<TbBrand> selectByExample = (Page<TbBrand>) mapper.selectByExample(null);
		return new PageResult(selectByExample.getTotal(), selectByExample.getResult());
	}


	//新增方法
	@Override
	public void add(TbBrand dto) {
		mapper.insert(dto);
		
		
	}


	//修改
	@Override
	public void update(TbBrand dto) {
		mapper.updateByPrimaryKey(dto);
	}


	//单个查询，用于修改
	@Override
	public TbBrand queryOne(long id) {
		return mapper.selectByPrimaryKey(id);
	}


	@Override
	public void delete(long[] ids) {
		// TODO Auto-generated method stub
		for(long id : ids){
			mapper.deleteByPrimaryKey(id);	
		}
		
		
	}


	@Override
	public PageResult queryPage(TbBrand dto, int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		
		TbBrandExample example = new TbBrandExample();
		Criteria createCriteria = example.createCriteria();
		
		if (dto != null) {
			if (dto.getName()!= null && dto.getName().length()>0) {
				createCriteria.andNameLike("%"+dto.getName()+"%");
			}
			if (dto.getFirstChar() != null && dto.getFirstChar().length()>0) {
				createCriteria.andFirstCharLike("%"+dto.getFirstChar()+"%");
			}
		}
		
		
		Page<TbBrand> page = (Page<TbBrand>)mapper.selectByExample(example);
		return new PageResult(page.getTotal(), page.getResult());
	}

}
