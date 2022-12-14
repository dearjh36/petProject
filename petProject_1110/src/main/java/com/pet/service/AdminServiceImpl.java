package com.pet.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.pet.dao.AdminDao;
import com.pet.model.MemberVO;
import com.pet.model.MtmVO;
import com.pet.model.OrderDTO;
import com.pet.model.ProductVO;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Inject
	AdminDao dao;

	// 상품 등록
	@Override
	public void insertProduct(ProductVO vo) throws Exception {
		dao.insertProduct(vo);
	}

	@Override
	public List<OrderDTO> adminOrderList(String id) throws Exception {
		return dao.adminOrderList(id);
	}

	@Override
	public void updateFinishOrderResult(int odNum) throws Exception {
		dao.updateFinishOrderResult(odNum);
	}
	
	@Override
	public void updateOrderResult(int odNum) throws Exception {
		dao.updateFinishOrderResult(odNum);
	}

	@Override
	public List<OrderDTO> cancelListOrder(String id) throws Exception {
		return dao.cancelListOrder(id);
	}

	@Override
	public List<MemberVO> memberList(String name) throws Exception {
		return dao.memberList(name);
	}

	@Override
	public List<OrderDTO> PriceRank(String key) throws Exception {
		return dao.PriceRank(key);
	}

	@Override
	public List<MtmVO> listAllMtm() throws Exception {
		return dao.listAllMtm();
	}
	
}
