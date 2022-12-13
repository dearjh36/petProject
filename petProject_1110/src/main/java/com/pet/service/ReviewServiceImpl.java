package com.pet.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.pet.dao.ReviewDao;
import com.pet.model.ReviewVO;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Inject
	ReviewDao dao;

	@Override
	public void insertWrite(ReviewVO vo) throws Exception {
		dao.insertWrite(vo);
	}

	@Override
	public void modifyResult(int odNum) throws Exception {
		dao.modifyResult(odNum);
	}

	@Override
	public List<ReviewVO> selectReview(int pNum) throws Exception {

		List<ReviewVO> cart = dao.selectReview(pNum);
		return cart;
	}

	@Override
	public ReviewVO selectOdNumReview(int odNum) throws Exception {

		ReviewVO vo = dao.selectOdNumReview(odNum);
		return vo;
	}

	@Override
	public void modifyReview(ReviewVO vo) throws Exception {
		dao.modifyReview(vo);
	}

}
