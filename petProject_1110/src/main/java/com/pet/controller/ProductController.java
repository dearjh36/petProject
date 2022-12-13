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
import com.pet.model.ReviewVO;
import com.pet.service.ProductService;
import com.pet.service.ReviewService;

@Controller
@RequestMapping(value = "/product")
public class ProductController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Inject
	private ProductService pService;

	@Inject
	private ReviewService rService;

	// 상품 상세보기
	@RequestMapping(value = "/productDetail", method = RequestMethod.GET)
	public void getDogMain(@RequestParam("pNum") int pNum, Model model) throws Exception {

		ProductVO productVO = pService.productView(pNum);
		model.addAttribute("productVO", productVO);

		List<ReviewVO> reviewList = rService.selectReview(pNum);
		model.addAttribute("reviewList", reviewList);

		logger.info("상품상세보기 : " + productVO.toString());

	}

}
