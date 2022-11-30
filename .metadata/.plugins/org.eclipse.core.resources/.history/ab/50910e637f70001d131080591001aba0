package com.pet.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pet.model.CategoryVO;

@Repository
public class CategoryDaoImpl implements CategoryDao{
	
	@Autowired
	private SqlSession sql;
	
	private static String namespace = "com.pet.mapper.CategoryMapper";

	// 카테고리 목록
	@Override
	public List<CategoryVO> categoryList() throws Exception {
		return sql.selectList(namespace+".categoryList");
	}
	
	
	
}
