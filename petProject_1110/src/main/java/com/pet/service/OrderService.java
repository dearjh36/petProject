package com.pet.service;

import com.pet.model.OrderDTO;

public interface OrderService {

	// P_order 추가
	public void insertPOrder(OrderDTO dto) throws Exception;

	// oNum 값 가져오기
	public int getONum() throws Exception;
}
