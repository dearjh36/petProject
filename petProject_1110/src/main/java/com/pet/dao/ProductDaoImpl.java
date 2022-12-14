package com.pet.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pet.model.ProductVO;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private SqlSession sql;

	private static String namespace = "com.pet.mapper.ProductMapper";

	// 상품 목록
	@Override
	public List<ProductVO> productList(String cateName) throws Exception {
		return sql.selectList(namespace + ".productList", cateName);
	}

	// 전체 상품 목록
	@Override
	public List<ProductVO> productAllList() throws Exception {
		return sql.selectList(namespace + ".productAllList");
	}

	// 상품 이름 검색
	@Override
	public List<ProductVO> productName(String pName) throws Exception {
		return sql.selectList(namespace+".productName", pName);
	}

	// 전체 상품 목록 + 페이징
	@Override
	public List<ProductVO> productAllListPage(int displayPost) throws Exception {
		return sql.selectList(namespace + ".productAllListPage", displayPost);
	}

	// 상품 상세보기
	@Override
	public ProductVO productView(int pNum) throws Exception {
		return sql.selectOne(namespace + ".productView", pNum);
	}

	// 종류별 상품 목록
	@Override
	public List<ProductVO> productKindList(String cateName, String kind) throws Exception {

		HashMap<String, String> data = new HashMap<String, String>();

		data.put("cateName", cateName);
		data.put("kind", kind);

		return sql.selectList(namespace + ".productKindList", data);
	}

	// 상품 갯수
	@Override
	public int countProduct() throws Exception {
		return sql.selectOne(namespace + ".countProduct");
	}

	// 상품 kind&cateCode 검색
	@Override
	public List<ProductVO> productSearch(String pName, String kind, String cateCode, int displayPost) throws Exception {

		HashMap<String, Object> data = new HashMap<String, Object>();

		data.put("pName", pName);
		data.put("kind", kind);
		data.put("cateCode", cateCode);
		data.put("displayPost", displayPost);

		return sql.selectList(namespace + ".productSearch", data);
	}

}
