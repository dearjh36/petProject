package com.pet.dao;

import com.pet.model.MemberVO;

public interface MemberDao {

	// 회원가입
	public void mJoin(MemberVO memVO) throws Exception;

	// 로그인
	public MemberVO mLogin(MemberVO memVO) throws Exception;
	
	// 아이디 중복 검사
	public int idCheck(String mId);
	
}
