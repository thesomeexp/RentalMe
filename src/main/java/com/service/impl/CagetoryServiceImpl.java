package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.CategoryMapper;
import com.pojo.Category;
import com.pojo.CategoryExample;
import com.service.IcategoryService;

@Service
public class CagetoryServiceImpl implements IcategoryService{

    @Autowired
    private CategoryMapper categoryMapper;
    
    @Override
    public List<Category> listAll() {
        CategoryExample categoryExample = new CategoryExample();
        return categoryMapper.selectByExample(categoryExample);
    }

	@Override
	public Category get(int cid) {
		
		return categoryMapper.selectByPrimaryKey(cid);
	}

	@Override
	public int insert(Category category) {
		
		return categoryMapper.insertSelective(category);
	}

	@Override
	public int delete(int cid) {
		
		return categoryMapper.deleteByPrimaryKey(cid);
	}
    
}
