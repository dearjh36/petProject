package com.pet.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.pet.dao.ProductDao;
import com.pet.model.ProductVO;

@Service
public class ProductServiceImpl implements ProductService {

	@Inject
	private ProductDao dao;

	// 상품 목록
	@Override
	public List<ProductVO> productList(String cateName) throws Exception {

		List<ProductVO> result = dao.productList(cateName);
		return result;
		
	}
	
	// 전체 상품 목록
	@Override
	public List<ProductVO> productAllList() throws Exception {

		List<ProductVO> result = dao.productAllList();
		return result;
				
	}

	// 상품 이름 검색
	@Override
	public List<ProductVO> productName(String pName) throws Exception {
		List<ProductVO> result = dao.productName(pName);
		return result;
	}
	
	// 전체 상품 목록 + 페이징
	@Override
	public List<ProductVO> productAllListPage(int displayPost) throws Exception {
		
		List<ProductVO> result = dao.productAllListPage(displayPost);
		return result;
		
	}

	// 상품 상세보기
	@Override
	public ProductVO productView(int pNum) throws Exception {
		
		ProductVO result = dao.productView(pNum);
		return result;
		
	}

	// 종류별 상품 목록
	@Override
	public List<ProductVO> productKindList(String cateName, String kind) throws Exception {
		
		List<ProductVO> result = dao.productKindList(cateName, kind);
		return result;
		
	}

	// 상품 갯수
	@Override
	public int countProduct() throws Exception {
		return dao.countProduct();
	}

	// 상품 kind&cateCode 검색
	@Override
	public List<ProductVO> productSearch(String pName, String kind, String cateCode, int displayPost) throws Exception {

		List<ProductVO> result = dao.productSearch(pName, kind, cateCode, displayPost);
		return result;
		
	}

}
