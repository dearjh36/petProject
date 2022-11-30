package com.pet.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pet.model.ProductVO;
import com.pet.service.ProductService;

public class ProductController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Inject 
	private ProductService pService;
	
	// 1. 강아지 메인 페이지
	@RequestMapping(value = "/product_detail", method = RequestMethod.GET)
	public void getDogMain(@RequestParam("cateName") String cateName, Model model) throws Exception{
		
		List<ProductVO> pList = pService.productList(cateName);
		model.addAttribute("ProductList",pList);
		
		logger.info("Dog 메인 페이지");
	}

}