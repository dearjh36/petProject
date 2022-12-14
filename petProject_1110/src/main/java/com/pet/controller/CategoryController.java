package com.pet.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pet.model.ProductVO;
import com.pet.service.CategoryService;
import com.pet.service.ProductService;

@Controller
public class CategoryController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Inject
	private CategoryService cService;

	@Inject
	private ProductService pService;

	// 카테고리 별 메인 페이지
	@RequestMapping(value = "/cate_main", method = RequestMethod.GET)
	public String getCateMain(Model model, @RequestParam("cateName") String cateName) throws Exception {

		List<ProductVO> pList = pService.productList(cateName);
		model.addAttribute("ProductList", pList);

		logger.info("CateName : " + cateName);

		return "/" + cateName + "_main";
	}

	// 강아지 종류별 상품 목록
	@RequestMapping(value = "/dog_product_kind", method = RequestMethod.GET)
	public String getDogKindMain(@RequestParam("kind") String kind, Model model) throws Exception {
		
		String cateName = "dog";
		
		List<ProductVO> pkindList = pService.productKindList(cateName, kind);
		model.addAttribute("ProductList", pkindList);

		return "/dog_main";

	}
	
	// 고양이 종류별 상품 목록
	@RequestMapping(value = "/cat_product_kind", method = RequestMethod.GET)
	public String getCatKindMain(@RequestParam("kind") String kind, Model model) throws Exception {
		
		String cateName = "cat";
		
		List<ProductVO> pkindList = pService.productKindList(cateName, kind);
		model.addAttribute("ProductList", pkindList);
		
		return "/cat_main";
		
	}
	
	// 새 종류별 상품 목록
	@RequestMapping(value = "/bird_product_kind", method = RequestMethod.GET)
	public String getDirdKindMain(@RequestParam("kind") String kind, Model model) throws Exception {
		
		String cateName = "bird";
		
		List<ProductVO> pkindList = pService.productKindList(cateName, kind);
		model.addAttribute("ProductList", pkindList);
		
		return "/bird_main";
		
	}
	
	// 파충류 종류별 상품 목록
	@RequestMapping(value = "/rep_product_kind", method = RequestMethod.GET)
	public String getRepKindMain(@RequestParam("kind") String kind, Model model) throws Exception {
		
		String cateName = "rep";
		
		List<ProductVO> pkindList = pService.productKindList(cateName, kind);
		model.addAttribute("ProductList", pkindList);
		
		return "/rep_main";
		
	}
}
