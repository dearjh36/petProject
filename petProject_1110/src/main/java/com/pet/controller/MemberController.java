package com.pet.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pet.model.MemberVO;
import com.pet.model.OrderDTO;
import com.pet.service.MemberService;
import com.pet.service.OrderService;

@Controller
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Inject
	private MemberService mService;

	@Inject
	private OrderService oService;

	// 회원가입 GET
	@RequestMapping(value = "/member/contract", method = RequestMethod.GET)
	public void getJoinContract() throws Exception {
	}

	// 회원가입 GET
	@RequestMapping(value = "/member/join", method = RequestMethod.GET)
	public void getJoin() throws Exception {
		logger.info("get 회원가입");
	}

	// 회원가입 POST
	@RequestMapping(value = "/member/join", method = RequestMethod.POST)
	public String postJoin(MemberVO memVO) throws Exception {
		logger.info("post 회원가입");
		logger.info(memVO.toString());

		mService.mJoin(memVO);

		return "redirect:/member/joinSuccess";
	}

	// 회원가입 성공
	@RequestMapping(value = "/member/joinSuccess", method = RequestMethod.GET)
	public void getJoinSuccess() throws Exception {
		logger.info("회원가입 성공");
	}

	// 회원정보 수정
	@RequestMapping(value = "/mypage/userUpdate", method = RequestMethod.GET)
	public void getMemberUpdate() throws Exception {
		logger.info("get 회원정보 수정 페이지");
		
		
	}
	
	// 로그인 GET
	@RequestMapping(value = "/member/login", method = RequestMethod.GET)
	public void getLogin() throws Exception {
		logger.info("get 로그인");
	}

	// 로그인 POST
	@RequestMapping(value = "/member/login", method = RequestMethod.POST)
	public String postLogin(MemberVO memVO, HttpServletRequest req, RedirectAttributes rttr) throws Exception {
		logger.info("get 로그인");

		MemberVO login = mService.mLogin(memVO);
		HttpSession session = req.getSession();

		if (login != null) {
			session.setAttribute("member", login);

			if (login.getId().equals("admin")) {
				session.setAttribute("member", login);
				return "redirect:/admin/product/productList?num=1";
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
	@RequestMapping(value = "/member/logout", method = RequestMethod.GET)
	public String Logout(HttpSession session) throws Exception {

		logger.info("get 로그아웃");

		mService.mLogout(session);

		return "redirect:/";

	}

	// 아이디 중복 검사
	@RequestMapping(value = "/member/memberIdChk", method = RequestMethod.POST)
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

	// 마이페이지
	@RequestMapping(value = "/mypage/mypage", method = RequestMethod.GET)
	public void myPageGET(HttpServletRequest req, Model model) throws Exception {

		HttpSession session = req.getSession();
		MemberVO mVO = (MemberVO) session.getAttribute("member");

		String id = mVO.getId();
		String cateName = mVO.getCateName();

		System.out.println("myPage Id : " + id);
		List<Integer> oNumList = oService.ONumList(id);
		ArrayList<OrderDTO> orderList = new ArrayList<OrderDTO>();

		for (int oNum : oNumList) {
			List<OrderDTO> orderList2 = oService.orderList(oNum, id);
			OrderDTO Odto = orderList2.get(0);
			Odto.setpName(Odto.getpName() + " 외 " + orderList2.size() + "건");
			
			int totalPrice = 0;
			for(OrderDTO Odto2 : orderList2) {
				totalPrice += Odto2.getpPrice() * Odto.getCnt();
			}
			
			Odto.setpPrice(totalPrice);
			orderList.add(Odto);
		}
		
		model.addAttribute("orderList",orderList);
		model.addAttribute("cateName",cateName);

	}
}
