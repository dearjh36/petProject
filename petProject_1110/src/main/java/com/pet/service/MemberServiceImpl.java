package com.pet.service;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.pet.dao.MemberDao;
import com.pet.model.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

	@Inject
	private MemberDao memDAO;

	// 회원 가입
	@Override
	public void mJoin(MemberVO memVO) throws Exception {

		memDAO.mJoin(memVO);

	}

	// 로그인
	@Override
	public MemberVO mLogin(MemberVO memVO) throws Exception {
		return memDAO.mLogin(memVO);
	}

	// 로그아웃
	@Override
	public void mLogout(HttpSession session) throws Exception {
		session.invalidate(); // 세션 데이터 삭제로 로그아웃
	}

	@Override
	public int idCheck(String mId) throws Exception {
		return memDAO.idCheck(mId);
	}
}
