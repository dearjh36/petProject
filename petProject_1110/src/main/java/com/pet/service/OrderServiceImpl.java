package com.pet.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.pet.dao.OrderDao;
import com.pet.model.P_orderVO;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Inject
	OrderDao oDao;

	@Override
	public void insertOrder(String id) throws Exception {
		oDao.insertOrder(id);
	}
	
	

}
