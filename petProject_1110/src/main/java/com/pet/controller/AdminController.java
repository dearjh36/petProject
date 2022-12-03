package com.pet.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pet.model.MemberVO;
import com.pet.model.Page;
import com.pet.model.ProductVO;
import com.pet.service.AdminService;
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
	
	@Inject
	private AdminService aService;

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
				return "redirect:/admin/product/productList?num=1";
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

	// 관리자 상품 목록 + 페이징
	@RequestMapping(value = "/product/productList", method = RequestMethod.GET)
	public void adminProductListGET(Model model, @RequestParam("num") int num) throws Exception {

		String kindList[] = { "전체", "사료", "간식", "용품" };
		String cateCodeList[] = { "전체", "강아지", "고양이", "새", "파충류" };
		model.addAttribute("kindList", kindList);
		model.addAttribute("cateCodeList", cateCodeList);

		Page page = new Page();

		page.setNum(num);
		page.setCount(pService.countProduct());

		List<ProductVO> productList = null;
		productList = pService.productAllListPage(page.getDisplayPost());

		model.addAttribute("productList", productList);
		model.addAttribute("page", page);
		model.addAttribute("select", num);

	}

	// 관리자 상품 검색
	@RequestMapping(value = "/product/productSearch", method = RequestMethod.GET)
	public void adminProductSearchGET(Model model, HttpServletRequest req) throws Exception {

		String kind = req.getParameter("kind");
		String cateCode = req.getParameter("cateCode");
		String pName = req.getParameter("key");

		logger.info("kind : " + kind + ", cateCode : " + cateCode + ", pName : " + pName);

		String kindList[] = { "전체", "사료", "간식", "용품" };
		String cateCodeList[] = { "전체", "강아지", "고양이", "새", "파충류" };
		model.addAttribute("kindList", kindList);
		model.addAttribute("cateCodeList", cateCodeList);

		int num = 1;

		Page page = new Page();

		page.setNum(num);
		page.setCount(pService.countProduct());

		int num2 = page.getDisplayPost();

		logger.info("num2 : " + num2);

		List<ProductVO> productList = null;
		productList = pService.productSearch(pName, kind, cateCode, num2);

		logger.info(productList.toString());

		model.addAttribute("productList", productList);
		model.addAttribute("page", page);
		model.addAttribute("select", num);

	}

	// 관리자 상품 등록
	@RequestMapping(value = "/product/productWrite", method = RequestMethod.GET)
	public void adminProductWriteGET(Model model) throws Exception {

		String kindList[] = { "전체", "사료", "간식", "용품" };
		String cateCodeList[] = { "전체", "강아지", "고양이", "새", "파충류" };
		model.addAttribute("kindList", kindList);
		model.addAttribute("cateCodeList", cateCodeList);
		
	}
	// 관리자 상품 등록
	@RequestMapping(value = "/product/productWrite", method = RequestMethod.POST)
	public String adminProductWritePOST(ProductVO pVO, Model model, RedirectAttributes rttr) throws Exception {
		
		String kindList[] = { "전체", "사료", "간식", "용품" };
		String cateCodeList[] = { "전체", "강아지", "고양이", "새", "파충류" };
		model.addAttribute("kindList", kindList);
		model.addAttribute("cateCodeList", cateCodeList);
		
		aService.insertProduct(pVO);
		
		rttr.addFlashAttribute("enroll_result", pVO.getpName());
		
		return "redirect:/admin/product/productList?num=1";
	}

}
