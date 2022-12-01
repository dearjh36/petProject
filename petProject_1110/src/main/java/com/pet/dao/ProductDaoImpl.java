package com.pet.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pet.model.ProductVO;

@Repository
public class ProductDaoImpl implements ProductDao{
	
	@Autowired
	private SqlSession sql;
	
	private static String namespace = "com.pet.mapper.ProductMapper";

	// 상품 목록
	@Override
	public List<ProductVO> productList(String cateName) throws Exception {
		return sql.selectList(namespace+".productList", cateName);
	}
	
	// 전체 상품 목록
	@Override
	public List<ProductVO> productAllList() throws Exception {
		return sql.selectList(namespace+".productAllList");
	}

	// 상품 상세보기
	@Override
	public ProductVO productView(int pNum) throws Exception {
		return sql.selectOne(namespace+".productView", pNum);
	}

	// 종류별 상품 목록
	@Override
	public List<ProductVO> productKindList(String cateName, String kind) throws Exception {
		
		HashMap data = new HashMap();
		
		data.put("cateName", cateName);
		data.put("kind", kind);
		
		return sql.selectList(namespace + ".productKindList", data);
	}

	// 상품 갯수
	@Override
	public int countProduct() throws Exception {
		return sql.selectOne(namespace + ".countProduct");
	}

	
	
}
