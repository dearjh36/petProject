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

import com.pet.dao.OrderDao;
import com.pet.model.CartDTO;
import com.pet.model.MemberVO;
import com.pet.service.CartService;
import com.pet.service.OrderService;

@Controller
public class OrderController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

	@Inject
	private CartService cService;
	
	@Inject
	private OrderService oService;
	
	// 주문하기 페이지
	@RequestMapping(value = "/mypage/orderForm", method = RequestMethod.GET)
	public void formOrderGET(HttpServletRequest req, Model model) throws Exception {
		
		HttpSession session = req.getSession();
		MemberVO mVO = (MemberVO)session.getAttribute("member");
		
		String id = mVO.getId();
		int totalPrice = 0;
		
		List<CartDTO> cartList = cService.getCart(id);
		
		for(CartDTO cDTO : cartList) {
			totalPrice += cDTO.getpPrice() * cDTO.getCnt();
		}
		
		model.addAttribute("cartList", cartList);
		model.addAttribute("totalPrice", totalPrice);
		model.addAttribute("user",mVO);
	}
	
	// 장바구니에 주문하기 
	@RequestMapping(value = "/mypage/orderForm", method = RequestMethod.GET)
	public void insertOrderGET(HttpServletRequest req, Model model) throws Exception {
		
		HttpSession session = req.getSession();
		MemberVO mVO = (MemberVO)session.getAttribute("member");
		
		String id = mVO.getId();
		CartDTO cDTO;
		
		List<CartDTO> cartList = cService.getCart(id);
		
		oService.insertOrder(id);
		
		
		int max = 

		String name = req.getParameter("name");
    	String phone =req.getParameter("phone");
    	String addr =req.getParameter("address");
		
	}
}
