package com.pet.dao;

import com.pet.model.ProductVO;

public interface AdminDao {

	// 상품 등록
	public void insertProduct(ProductVO vo) throws Exception;
}