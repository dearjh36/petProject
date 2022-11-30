package com.pet.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.pet.dao.CategoryDao;
import com.pet.model.CategoryVO;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Inject
	private CategoryDao dao;
	
	// 카테고리 목록
	@Override
	public List<CategoryVO> categoryList() throws Exception {

		List<CategoryVO> result = dao.categoryList();
		
		return result;
	}
	

}
