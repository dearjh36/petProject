package com.pet.service;

import java.util.List;

import com.pet.model.MemberVO;
import com.pet.model.MtmVO;
import com.pet.model.OrderDTO;
import com.pet.model.ProductVO;

public interface AdminService {

	// 상품 등록
	public void insertProduct(ProductVO vo) throws Exception;

	// 주문번호 리스트
	public List<OrderDTO> adminOrderList(String id) throws Exception;
	
	public void updateFinishOrderResult(int odNum) throws Exception;
	
	public void updateOrderResult(int odNum) throws Exception;
	
	public List<OrderDTO> cancelListOrder(String id) throws Exception;
	
	public List<OrderDTO> PriceRank(String key) throws Exception;
	
	public List<MtmVO> listAllMtm() throws Exception;
	
	public List<MemberVO> memberList(String name) throws Exception;
}
