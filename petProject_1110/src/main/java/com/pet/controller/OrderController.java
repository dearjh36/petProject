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

import com.pet.model.CartDTO;
import com.pet.model.MemberVO;
import com.pet.service.CartService;

@Controller
public class OrderController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

	@Inject
	private CartService cService;
	
	// 주문하기 
	@RequestMapping(value = "/mypage/orderForm", method = RequestMethod.GET)
	public void adminMainGET(HttpServletRequest req, Model model) throws Exception {
		
		HttpSession session = req.getSession();
		MemberVO mVO = (MemberVO)session.getAttribute("member");
		
		String id = mVO.getId();
		String cateName = mVO.getCateName();
		int totalPrice = 0;
		
		List<CartDTO> cartList = cService.getCart(id);
		
		for(CartDTO cDTO : cartList) {
			totalPrice += cDTO.getpPrice() * cDTO.getCnt();
		}
		
		model.addAttribute("cartList", cartList);
		model.addAttribute("totalPrice", totalPrice);
		model.addAttribute("user",mVO);
	}
}
