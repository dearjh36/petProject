package com.pet.controller;

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

import com.pet.model.MemberVO;
import com.pet.model.MtmVO;
import com.pet.model.QnaVO;
import com.pet.service.QnaService;

@Controller
public class QnaController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Inject
	private QnaService qService;

	// Qna 목록
	@RequestMapping(value = "/qna/qnaList", method = RequestMethod.GET)
	public void getQnaList(Model model) throws Exception {
		List<QnaVO> qnaList = qService.qnaList();

		model.addAttribute("qnaList", qnaList);
	}
	
	// 1:1 문의하기
	@RequestMapping(value = "/mtm/mtmList", method = RequestMethod.GET)
	public void mtmList(Model model, HttpServletRequest req) throws Exception {
		
		HttpSession session = req.getSession();
		MemberVO mVO = (MemberVO)session.getAttribute("member");
		String id = mVO.getId();
		
		List<MtmVO> mtmList = qService.mtmList(id);		
		model.addAttribute("mtmList", mtmList);
	}
}
