package com.pet.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pet.model.ReviewVO;

@Repository
public class ReviewDaoImpl implements ReviewDao {

	@Autowired
	private SqlSession sql;

	private static String namespace = "com.pet.mapper.ReviewMapper";

	@Override
	public void insertWrite(ReviewVO vo) throws Exception {
		sql.insert(namespace + ".insertWrite", vo);
	}

	@Override
	public void modifyResult(int odNum) throws Exception {
		sql.update(namespace + ".modifyResult", odNum);
	}

	@Override
	public List<ReviewVO> selectReview(int pNum) throws Exception {
		return sql.selectList(namespace + ".selectReview", pNum);
	}

	@Override
	public ReviewVO selectOdNumReview(int odNum) throws Exception {
		return sql.selectOne(namespace + ".selectOdNumReview", odNum);
	}

	@Override
	public void modifyReview(ReviewVO vo) throws Exception {
		sql.update(namespace + ".modifyReview", vo);
	}

}
