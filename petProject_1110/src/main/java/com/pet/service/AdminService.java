package com.pet.service;

import com.pet.model.ProductVO;

public interface AdminService {
	
	// 상품 등록
	public void insertProduct(ProductVO vo) throws Exception;
}
