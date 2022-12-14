package com.pet.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.pet.dao.QnaDao;
import com.pet.model.MtmVO;
import com.pet.model.QnaVO;

@Service
public class QnaServiceImpl implements QnaService{
	
	@Inject
	QnaDao dao;

	@Override
	public List<QnaVO> qnaList() throws Exception {
		List<QnaVO> qna = dao.qnaList();
		return qna;
	}

	@Override
	public List<MtmVO> mtmList(String id) throws Exception {
		List<MtmVO> mtm = dao.mtmList(id);
		return mtm;
	}

	@Override
	public void mtmInsert(MtmVO vo) throws Exception {
		dao.mtmInsert(vo);
	}
	

}
