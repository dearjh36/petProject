package com.pet.dao;

import java.util.List;

import com.pet.model.CartDTO;

public interface CartDao {

	// 장바구니 추가
	public int addCart(CartDTO cart) throws Exception;
	
	// 장바구니 삭제
	public void deleteCart(int cNum) throws Exception;
	
	// 장바구니 수량 변경
	public int modifyCount(CartDTO cart) throws Exception;
	
	// 장바구니 목록
	public List<CartDTO> getCart(String id) throws Exception;
	
	// 장바구니 확인
	public CartDTO checkCart(CartDTO cart);
	
}
