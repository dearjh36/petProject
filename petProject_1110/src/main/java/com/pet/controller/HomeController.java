package com.pet.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pet.model.CategoryVO;
import com.pet.service.CategoryService;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Inject
	private CategoryService categoryService;
	
	// 메인페이지(index.jsp)
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) throws Exception {
		
		logger.info("메인 index 페이지");
		
		List<CategoryVO> cateList = categoryService.categoryList();
		
		model.addAttribute("cateList", cateList);
		
		return "index";
	}
	
	
}
