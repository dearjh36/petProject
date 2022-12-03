package com.pet.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pet.model.ProductVO;

@Repository
public class AdminDaoImpl implements AdminDao{
	
	@Autowired
	private SqlSession sql;
	
	private static String namespace = "com.pet.mapper.AdminMapper";

	// 상품 등록
	@Override
	public void insertProduct(ProductVO vo) throws Exception {
		sql.insert(namespace+".insertProduct", vo);		
	}

}
