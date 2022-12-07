package com.pet.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pet.model.CartDTO;
import com.pet.model.MemberVO;
import com.pet.service.CartService;

@Controller
public class CartController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

	@Inject
	private CartService cService;

	// 장바구니 추가
	@PostMapping("/cart/add")
	@ResponseBody
	public String addCartGET(CartDTO cart, HttpServletRequest req) throws Exception {
		
		// 로그인 체크
		HttpSession session = req.getSession();
		MemberVO mVO = (MemberVO)session.getAttribute("member");
		if(mVO == null) {
			return "5";
		}
		
		String id = mVO.getId();
		cart.setId(id);
		
		logger.info("장바구니 추가 GET");
		
		// 카트 등록
		int result = cService.addCart(cart);
		
		return result + "";
	}
	
	// 장바구니 리스트
	@RequestMapping(value = "/mypage/cartList", method = RequestMethod.GET)
	public void adminMainGET(HttpServletRequest req, Model model) throws Exception {
		
		HttpSession session = req.getSession();
		MemberVO mVO = (MemberVO)session.getAttribute("member");
		
		logger.info("장바구니 리스트" +mVO.toString());
		
		String id = mVO.getId();
		String cateName = mVO.getCateName();
		int totalPrice = 0;
		
		List<CartDTO> cartList = cService.getCart(id);
		
		for(CartDTO cDTO : cartList) {
			totalPrice += cDTO.getpPrice() * cDTO.getCnt();
		}
		
		model.addAttribute("cartList", cartList);
		model.addAttribute("cateName", cateName);		
		model.addAttribute("totalPrice", totalPrice);
		
	}
	
	@RequestMapping(value="/cart/delete")
	public String deleteGET(@RequestParam("cNum") int cNum) throws Exception {
		
		cService.deleteCart(cNum);
		
		return "redirect:/mypage/cartList";		
	}

}
