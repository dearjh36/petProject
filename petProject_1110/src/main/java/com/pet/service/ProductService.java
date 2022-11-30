package com.pet.service;

import java.util.List;

import com.pet.model.ProductVO;

public interface ProductService {

	// 상품 목록
	public List<ProductVO> productList(String cateName) throws Exception;

	// 상품 상세보기
	public ProductVO productView(int pNum) throws Exception;

	// 종류별 상품 목록
	public List<ProductVO> productKindList(String cateName, String kind) throws Exception;
}
