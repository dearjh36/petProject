package com.pet.dao;

import java.util.List;

import com.pet.model.CategoryVO;

public interface CategoryDao {

	// 카테고리 목록
	public List<CategoryVO> categoryList() throws Exception;

	
}
