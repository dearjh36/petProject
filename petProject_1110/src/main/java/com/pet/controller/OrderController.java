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
import org.springframework.web.bind.annotation.RequestParam;

import com.pet.model.CartDTO;
import com.pet.model.MemberVO;
import com.pet.model.OrderDTO;
import com.pet.service.CartService;
import com.pet.service.OrderService;

@Controller
public class OrderController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

	@Inject
	private CartService cService;

	@Inject
	private OrderService oService;

	// 장바구니 주문하기 페이지
	@RequestMapping(value = "/mypage/cartOrderForm", method = RequestMethod.GET)
	public void formCartOrderGET(HttpServletRequest req, Model model) throws Exception {

		HttpSession session = req.getSession();
		MemberVO mVO = (MemberVO) session.getAttribute("member");

		String id = mVO.getId();
		int totalPrice = 0;

		List<CartDTO> cartList = cService.getCart(id);

		for (CartDTO cDTO : cartList) {
			totalPrice += cDTO.getpPrice() * cDTO.getCnt();
		}

		model.addAttribute("cartList", cartList);
		model.addAttribute("totalPrice", totalPrice);
		model.addAttribute("user", mVO);

	}

	// 장바구니 주문하기
	@RequestMapping(value = "/mypage/cartOrderForm", method = RequestMethod.POST)
	public String formCartOrderPOST(HttpServletRequest req, Model model, OrderDTO Odto) throws Exception {

		HttpSession session = req.getSession();
		MemberVO mVO = (MemberVO) session.getAttribute("member");

		String id = mVO.getId();
		String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		String addr = req.getParameter("address");

		Odto.setID(id);
		Odto.setOname(name);
		Odto.setOphone(phone);
		Odto.setOaddress(addr);

		oService.insertPOrder(Odto);

		int oNum = oService.getONum();
		Odto.setoNum(oNum);

		List<CartDTO> cartList = cService.getCart(id);
		for (CartDTO Cdto : cartList) {
			Odto.setCnt(Cdto.getCnt());
			Odto.setpNum(Cdto.getpNum());

			System.out.println("Odto : " + Odto.toString());
			oService.insertODetail(Odto);
			cService.deleteCart(Cdto.getcNum());
		}

		return "redirect:/mypage/orderList?oNum=" + oNum;

	}

	// 상품 상세정보 바로 구매 페이지
	@RequestMapping(value = "/mypage/productOrder", method = RequestMethod.GET)
	public void formProductOrderGET(HttpServletRequest req, Model model) throws Exception {
		/*
		 * HttpSession session = req.getSession(); MemberVO mVO =
		 * (MemberVO)session.getAttribute("member");
		 * 
		 * String id = mVO.getId(); CartDTO cDTO;
		 * 
		 * List<CartDTO> cartList = cService.getCart(id);
		 * 
		 * oService.insertOrder(id);
		 */
	}

	// 주문 리스트
	@RequestMapping(value = "/mypage/orderList", method = RequestMethod.GET)
	public void orderListGET(HttpServletRequest req, @RequestParam("oNum") int oNum, Model model) throws Exception {
		HttpSession session = req.getSession();
		MemberVO mVO = (MemberVO) session.getAttribute("member");

		String id = mVO.getId();
		
		List<OrderDTO> orderList = oService.orderList(oNum, id);

		int totalPrice = 0;
		for (OrderDTO orderVO : orderList) {
			totalPrice += orderVO.getpPrice() * orderVO.getCnt();
		}

		model.addAttribute("orderList", orderList);
		model.addAttribute("totalPrice", totalPrice);
	}
	
	// 주문 리스트
	@RequestMapping(value = "/mypage/orderDetail", method = RequestMethod.GET)
	public void orderDetailGET(HttpServletRequest req, @RequestParam("oNum") int oNum, Model model) throws Exception {
		HttpSession session = req.getSession();
		MemberVO mVO = (MemberVO) session.getAttribute("member");
		
		String id = mVO.getId();
		
		List<OrderDTO> orderList = oService.orderList(oNum, id);
		
		int totalPrice = 0;
		for (OrderDTO orderVO : orderList) {
			totalPrice += orderVO.getpPrice() * orderVO.getCnt();
		}
		
		model.addAttribute("orderDetail", orderList.get(0));
		model.addAttribute("orderList", orderList);
		model.addAttribute("totalPrice", totalPrice);
	}

}
