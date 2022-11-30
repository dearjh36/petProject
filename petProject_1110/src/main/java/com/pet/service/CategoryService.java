package com.pet.service;

import java.util.List;

import com.pet.model.CategoryVO;

public interface CategoryService {

	// 카테고리 목록
	public List<CategoryVO> categoryList() throws Exception;

}
