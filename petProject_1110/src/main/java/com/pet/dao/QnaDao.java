package com.pet.dao;

import java.util.List;

import com.pet.model.MtmVO;
import com.pet.model.QnaVO;

public interface QnaDao {

	// 장바구니 목록
	public List<QnaVO> qnaList() throws Exception;
	
	// mtm 목록
	public List<MtmVO> mtmList(String id) throws Exception;
	
	// mtm 삽입
	public void mtmInsert(MtmVO vo) throws Exception;
}
