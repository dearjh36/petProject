package com.pet.service;

import java.util.List;

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

	@Override
	public void insertODetail(OrderDTO dto) throws Exception {
		oDao.insertODetail(dto);
	}

	@Override
	public List<OrderDTO> orderList(int oNum, String id) throws Exception {
		return oDao.orderList(oNum,id);
	}

	@Override
	public List<Integer> ONumList(String id) throws Exception {
		return oDao.ONumList(id);
	}

	@Override
	public void orderCancel(int odNum) throws Exception {
		oDao.orderCancel(odNum);
	}
	
	

}
