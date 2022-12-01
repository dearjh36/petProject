package com.pet.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.pet.model.MemberVO;

@Repository
public class MemberDaoImpl implements MemberDao {

	@Inject
	private SqlSession sqlsession;
	
	private static String namespace = "com.pet.mapper.MemberMapper";

	// 회원 가입
	@Override
	public void mJoin(MemberVO memVO) throws Exception {
		sqlsession.insert(namespace + ".mJoin",memVO);
	}

	// 로그인
	@Override
	public MemberVO mLogin(MemberVO memVO) throws Exception {
		return sqlsession.selectOne(namespace + ".mLogin", memVO);		
	}

	@Override
	public int idCheck(String mId) {
		return sqlsession.selectOne(namespace + ".idCheck", mId);
	}
	
}
