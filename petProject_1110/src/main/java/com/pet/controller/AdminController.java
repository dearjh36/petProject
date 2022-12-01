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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pet.model.MemberVO;
import com.pet.model.ProductVO;
import com.pet.service.MemberService;
import com.pet.service.ProductService;

@Controller
@RequestMapping("/admin/")
public class AdminController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

	@Inject
	private MemberService mService;
	
	@Inject
	private ProductService pService;

	// 관리자 로그인 화면
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public void adminMainGET() throws Exception {

	}

	// 관리자 로그인 화면
	@RequestMapping(value = "/main", method = RequestMethod.POST)
	public String adminMainPOST(MemberVO memVO, HttpServletRequest req, RedirectAttributes rttr) throws Exception {
		MemberVO login = mService.mLogin(memVO);
		HttpSession session = req.getSession();

		if (login != null) {
			session.setAttribute("member", login);

			if (login.getId().equals("admin")) {
				session.setAttribute("member", login);
				return "redirect:/admin/product/productList";
			} else {
				session.setAttribute("member", null);
				rttr.addFlashAttribute("msg", false);
				return "redirect:/admin/main";
			}

		} else {
			session.setAttribute("member", null);
			rttr.addFlashAttribute("msg", false);
			return "redirect:/admin/main";
		}
	}

	// 관리자 상품 목록
	@RequestMapping(value = "/product/productList", method = RequestMethod.GET)
	public void adminProductListGET(Model model) throws Exception {

		String kindList[] = { "전체", "사료", "간식", "용품" };
		String cateCodeList[] = { "전체", "강아지", "고양이", "새", "파충류" };
		model.addAttribute("kindList", kindList);
		model.addAttribute("cateCodeList", cateCodeList);
		
		List<ProductVO> productList = null;
		productList = pService.productAllList();

		model.addAttribute("productList", productList);
		
	}

}
