package com.pet.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.pet.dao.AdminDao;
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
	
}
