package com.pet.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public void mainPageGet() {
		logger.info("메인 페이지 진입");
	}
}
