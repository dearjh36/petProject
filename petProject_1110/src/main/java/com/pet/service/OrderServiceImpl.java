package com.pet.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.pet.dao.OrderDao;
import com.pet.model.OrderDTO;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Inject
	OrderDao oDao;

	@Override
	public void insertPOrder(OrderDTO dto) throws Exception {
		oDao.insertPOrder(dto);
	}

	@Override
	public int getONum() throws Exception {
		return oDao.getONum();
	}
	
	

}
