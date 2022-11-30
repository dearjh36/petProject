package com.pet.service;

import javax.servlet.http.HttpSession;

import com.pet.model.MemberVO;

public interface MemberService {

	// 회원 가입
	public void mJoin(MemberVO memVO) throws Exception;

	// 로그인
	public MemberVO mLogin(MemberVO memVO) throws Exception;

	// 로그아웃
	public void mLogout(HttpSession session) throws Exception;
	
	/* 아이디 중복 검사 */
	public int idCheck(String mId) throws Exception;

}
