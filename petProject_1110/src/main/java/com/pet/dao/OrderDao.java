package com.pet.dao;

import com.pet.model.P_orderVO;

public interface OrderDao {
	
	// P_order 추가
	public void insertOrder(String id) throws Exception;
}
