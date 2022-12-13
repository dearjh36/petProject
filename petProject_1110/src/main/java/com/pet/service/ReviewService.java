package com.pet.service;

import java.util.List;

import com.pet.model.ReviewVO;

public interface ReviewService {

	// 리뷰 작성
	public void insertWrite(ReviewVO vo) throws Exception;

	// result 수정
	public void modifyResult(int odNum) throws Exception;

	// 상품 리뷰 보기
	public List<ReviewVO> selectReview(int pNum) throws Exception;

	// 주문 리뷰 보기
	public ReviewVO selectOdNumReview(int odNum) throws Exception;

	// 리뷰 수정
	public void modifyReview(ReviewVO vo) throws Exception;
}
