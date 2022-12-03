package com.pet.dao;

import java.util.List;

import com.pet.model.ProductVO;

public interface ProductDao {

	// 상품 목록
	public List<ProductVO> productList(String catecode) throws Exception;
	
	// 전체 상품 목록
	public List<ProductVO> productAllList() throws Exception;
	
	// 전체 상품 목록 + 페이징
	public List<ProductVO> productAllListPage(int displayPost) throws Exception;

	// 상품 상세보기
	public ProductVO productView(int pNum) throws Exception;
	
	// 종류별 상품 목록
	public List<ProductVO> productKindList(String cateName, String kind) throws Exception;
	
	// 상품 갯수
	public int countProduct() throws Exception;
	
	// 상품 kind&cateCode 검색
	public List<ProductVO> productSearch(String pName, String kind, String cateCode, int displayPost) throws Exception;

	
}
