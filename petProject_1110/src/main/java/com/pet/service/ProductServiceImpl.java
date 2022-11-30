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

}