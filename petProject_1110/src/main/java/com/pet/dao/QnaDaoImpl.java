package com.pet.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pet.model.MtmVO;
import com.pet.model.QnaVO;

@Repository
public class QnaDaoImpl implements QnaDao {

	@Autowired
	private SqlSession sql;

	// mapper파일의 namespace
	private static String namespace = "com.pet.mapper.QnaMapper";

	@Override
	public List<QnaVO> qnaList() throws Exception {
		return sql.selectList(namespace + ".qnaList");
	}

	@Override
	public List<MtmVO> mtmList(String id) throws Exception {
		return sql.selectList(namespace + ".mtmList", id);
	}

	@Override
	public void mtmInsert(MtmVO vo) throws Exception {
		sql.insert(namespace+".mtmInsert",vo);
	}

}
