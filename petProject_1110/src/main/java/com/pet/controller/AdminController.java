package com.pet.controller;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pet.model.MemberVO;
import com.pet.model.MtmVO;
import com.pet.model.OrderDTO;
import com.pet.model.Page;
import com.pet.model.ProductVO;
import com.pet.model.QnaVO;
import com.pet.service.AdminService;
import com.pet.service.MemberService;
import com.pet.service.ProductService;
import com.pet.service.QnaService;
import com.pet.util.UploadFileUtils;

@Controller
@RequestMapping("/admin/")
public class AdminController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

	@Inject
	private MemberService mService;

	@Inject
	private ProductService pService;
	
	@Inject
	private QnaService qService;

	@Inject
	private AdminService aService;

	@Resource(name = "uploadPath")
	private String uploadPath;

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
	public String adminProductWritePOST(ProductVO pVO, Model model, HttpServletRequest req,
			@RequestParam(value = "fileImg") MultipartFile pImg) throws Exception {

		String kindList[] = { "전체", "사료", "간식", "용품" };
		String cateCodeList[] = { "전체", "강아지", "고양이", "새", "파충류" };
		model.addAttribute("kindList", kindList);
		model.addAttribute("cateCodeList", cateCodeList);

		String cateName = req.getParameter("cateCode");
		logger.info(cateName);

		switch (cateName) {
		case "0":
			cateName = "전체";
			break;
		case "1":
			cateName = "dog";
			break;
		case "2":
			cateName = "cat";
			break;
		case "3":
			cateName = "bird";
			break;
		case "4":
			cateName = "rep";
			break;

		}
		pVO.setCateName(cateName);

		String imgUploadPath = uploadPath + File.separator + "imgUpload";
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		String fileName = null;
		logger.info(pImg.getOriginalFilename());

		if (pImg.getOriginalFilename() != null && pImg.getOriginalFilename() != "") {
			fileName = UploadFileUtils.fileUpload(imgUploadPath, pImg.getOriginalFilename(), pImg.getBytes(), ymdPath);
			logger.info(fileName);
			pVO.setpImg(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
		} else {
			fileName = uploadPath + File.separator + "images" + File.separator + "none.png";
			logger.info(fileName);
			pVO.setpImg(fileName);
		}

		aService.insertProduct(pVO);

		return "redirect:/admin/product/productList?num=1";
	}

	// 상품 상세보기
	@RequestMapping(value = "/product/productDetail", method = RequestMethod.GET)
	public void adminProductDetailGET(@RequestParam("pNum") int pNum, Model model) throws Exception {

		ProductVO pVO = pService.productView(pNum);
		model.addAttribute("productVO", pVO);

		String kindList[] = { "전체", "사료", "간식", "용품" };
		String cateCodeList[] = { "전체", "강아지", "고양이", "새", "파충류" };
		model.addAttribute("kindList", kindList);
		model.addAttribute("cateCodeList", cateCodeList);

	}

	// 상품 수정하기
	@RequestMapping(value = "/product/productModify", method = RequestMethod.POST)
	public void adminProductModifyPOST(ProductVO pVO, HttpServletRequest req, MultipartFile file) throws Exception {

		// 새로 파일 등록되었는지 확인
		if (file.getOriginalFilename() != null && file.getOriginalFilename() != "") {

			// 기존 파일 삭제
			new File(uploadPath + req.getParameter("pImg")).delete();

			// 새로 첨부한 파일을 등록
			String imgUploadPath = uploadPath + File.separator + "imgUpload";
			String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
			// String fileName = uploadPath.fil

		}

	}

	// 주문 목록
	@RequestMapping(value = "/p_order/p_orderList", method = RequestMethod.GET)
	public void adminOrderListGET(Model model) throws Exception {
		String key = "%";

		List<OrderDTO> p_orderList = aService.adminOrderList(key);
		model.addAttribute("p_orderList", p_orderList);

	}

	// 주문 목록
	@RequestMapping(value = "/p_order/p_orderList", method = RequestMethod.POST)
	public void adminOrderListPOST(HttpServletRequest req, Model model) throws Exception {
		String key = req.getParameter("key");

		List<OrderDTO> p_orderList = aService.adminOrderList(key);
		model.addAttribute("p_orderList", p_orderList);

	}

	// 주문 상태 변경
	@RequestMapping(value = "/p_order/state", method = RequestMethod.POST)
	public String adminOrderStatePOST(HttpServletRequest req, Model model) throws Exception {

		String[] resultArr = req.getParameterValues("state");

		for (String oseq : resultArr) {
			int odNum = Integer.parseInt(oseq);
			aService.updateFinishOrderResult(odNum);
		}

		return "redirect:/admin/p_order/p_orderList";
	}

	// 주문 취소 목록
	@RequestMapping(value = "/p_order/p_orderCancelList", method = RequestMethod.GET)
	public void adminOrderCancelListGET(Model model) throws Exception {
		String key = "%";

		List<OrderDTO> p_orderList = aService.cancelListOrder(key);
		model.addAttribute("p_orderList", p_orderList);

	}

	// 주문 취소 목록
	@RequestMapping(value = "/p_order/p_orderCancelList", method = RequestMethod.POST)
	public void adminOrderCancelListPOST(HttpServletRequest req, Model model) throws Exception {
		String key = req.getParameter("key");

		List<OrderDTO> p_orderList = aService.cancelListOrder(key);
		model.addAttribute("p_orderList", p_orderList);

	}

	// 주문 취소 목록
	@RequestMapping(value = "/p_order/Cancel", method = RequestMethod.POST)
	public String adminOrderCancelPOST(HttpServletRequest req) throws Exception {

		String[] resultArr = req.getParameterValues("state");

		for (String oseq : resultArr) {
			int odNum = Integer.parseInt(oseq);
			aService.updateOrderResult(odNum);
		}

		return "redirect:/admin/p_order/p_orderCancelList";
	}

	// 회원 목록
	@RequestMapping(value = "/member/memberList", method = RequestMethod.GET)
	public void adminMemberListGET(Model model) throws Exception {
		String key = "%";

		List<MemberVO> join_UserList = aService.memberList(key);
		model.addAttribute("join_UserList", join_UserList);

	}

	// 회원 랭크
	@RequestMapping(value = "/p_order/p_RankList", method = RequestMethod.GET)
	public void adminMemberRankGET(@RequestParam("key") String key, Model model) throws Exception {
		String kindList[] = { "갯수", "금액", "주문횟수", "카테분류" };
		model.addAttribute("kindList", kindList);

		List<OrderDTO> p_orderList = aService.PriceRank(key);
		model.addAttribute("p_orderList", p_orderList);
	}
	
	// 회원 랭크
	@RequestMapping(value = "/p_order/p_RankList", method = RequestMethod.POST)
	public void adminMemberRankPOST(Model model) throws Exception {
		String kindList[] = { "갯수", "금액", "주문횟수", "카테분류" };
		model.addAttribute("kindList", kindList);
		
		String key = "금액";
		List<OrderDTO> p_orderList = aService.PriceRank(key);
		model.addAttribute("p_orderList", p_orderList);
	}

	// mtmList
	@RequestMapping(value = "/mtm/mtmList", method = RequestMethod.GET)
	public void adminMtmListGET(Model model) throws Exception {
		List<MtmVO> mtmList = aService.listAllMtm();
		model.addAttribute("mtmList", mtmList);
	}
	
	// mtmList
	@RequestMapping(value = "/qna/adminqnaList", method = RequestMethod.GET)
	public void adminQnaListGET(Model model) throws Exception {
		List<QnaVO> qnaList = qService.qnaList();
		model.addAttribute("qnaList", qnaList);
	}
}
