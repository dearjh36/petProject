package com.pet.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pet.model.MemberVO;
import com.pet.service.MemberService;

@Controller
@RequestMapping(value = "/member")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Inject
	private MemberService mService;

	// 회원가입 GET
	@RequestMapping(value = "/contract", method = RequestMethod.GET)
	public void getJoinContract() throws Exception {
	}
	
	// 회원가입 GET
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public void getJoin() throws Exception {
		logger.info("get 회원가입");
	}

	// 회원가입 POST
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String postJoin(MemberVO memVO) throws Exception {
		logger.info("post 회원가입");
		logger.info(memVO.toString());

		mService.mJoin(memVO);

		return "redirect:/member/joinSuccess";
	}

	// 회원가입 성공
	@RequestMapping(value = "/joinSuccess", method = RequestMethod.GET)
	public void getJoinSuccess() throws Exception {
		logger.info("회원가입 성공");
	}

	// 로그인 GET
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void getLogin() throws Exception {
		logger.info("get 로그인");
	}

	// 로그인 POST
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String postLogin(MemberVO memVO, HttpServletRequest req, RedirectAttributes rttr) throws Exception {
		logger.info("get 로그인");

		MemberVO login = mService.mLogin(memVO);
		HttpSession session = req.getSession();

		if (login != null) {
			session.setAttribute("member", login);

			if (login.getId().equals("admin")) {
				session.setAttribute("member", login);
				return "redirect:/admin/product/productList";
			} else {
				return "redirect:/";
			}
		} else {
			session.setAttribute("member", null);
			rttr.addFlashAttribute("msg", false);
			return "redirect:/member/login";
		}

	}

	// 로그아웃
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String Logout(HttpSession session) throws Exception {

		logger.info("get 로그아웃");

		mService.mLogout(session);

		return "redirect:/";

	}

	// 아이디 중복 검사
	@RequestMapping(value = "/memberIdChk", method = RequestMethod.POST)
	@ResponseBody
	public String memberIdChkPOST(String memberId) throws Exception {

		logger.info("memberIdChk() 진입");

		int result = mService.idCheck(memberId);

		logger.info("결과값 = " + result);

		if (result != 0) {

			return "fail"; // 중복 아이디가 존재

		} else {

			return "success"; // 중복 아이디 x

		}

	} // memberIdChkPOST() 종료
}
