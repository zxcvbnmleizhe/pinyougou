package com.pinyougou.manager.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;

import entity.PageResult;
import entity.Result;



@RestController
@RequestMapping(value="brand")
public class BrandController {
	
//	在这里调用interface是需要依赖注入的,使用的是远程注入
	@Reference
	private BrandService service;
	
	
	@RequestMapping("/query")
	public List<TbBrand> queryAll() {
		System.out.println("11111");
		return service.queryAll();
	}
	
	@RequestMapping("/queryPage")
	public PageResult queryPage(int page,int size){
		
		/*int page = 1;
		int size = 10;*/
		PageResult queryPage = service.queryPage(page, size);
		return queryPage;
	}
	
	@RequestMapping("/add")
	public Result add(@RequestBody TbBrand dto){
		
		Result result;
		try {
			service.add(dto);
			result = new Result(true, "新增成功");
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = new Result(false, "失败，原因如下+");
			return result;
		}
	}
	
	//用于修改前的ID
	@RequestMapping("/queryOne")
	public TbBrand queryOne(long id){
		return service.queryOne(id);
	}
	
	@RequestMapping("/update")
	public Result update(@RequestBody TbBrand dto){
		Result result = new Result(false, null);
		try {
			service.update(dto);
			result.setSuccess(true);
			result.setMessage("保存成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.setMessage("失败");
		}
		return result;
		
	}

	@RequestMapping("/delete")
	public Result delete(long[] ids){
		
		Result result;
		try {
			service.delete(ids);
			result = new Result(true, "删除成功");
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = new Result(false, "失败，原因如下+");
			return result;
		}
	}
	
	@RequestMapping("/queryByTiaoJian")
	public PageResult queryByTiaoJian(@RequestBody TbBrand dto, int page,int size){
		PageResult queryPage = service.queryPage(dto, page, size);
		return queryPage;
	}
	
	
}
