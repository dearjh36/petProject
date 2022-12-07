package com.pet.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pet.model.CartDTO;

@Repository
public class CartDaoImpl implements CartDao {

	@Autowired
	private SqlSession sql;

	private static String namespace = "com.pet.mapper.CartMapper";

	// 장바구니 추가
	@Override
	public int addCart(CartDTO cart) throws Exception {
		return sql.insert(namespace + ".addCart", cart);
	}

	// 장바구니 삭제
	@Override
	public void deleteCart(int cNum) throws Exception {
		sql.delete(namespace + ".deleteCart", cNum);

	}

	// 장바구니 수량 수정
	@Override
	public int modifyCount(CartDTO cart) throws Exception {
		return sql.update(namespace + ".modifyCount", cart);
	}

	// 장바구니 목록
	@Override
	public List<CartDTO> getCart(String id) throws Exception {
		return sql.selectList(namespace + ".getCart", id);
	}

	// 장바구니 확인
	@Override
	public CartDTO checkCart(CartDTO cart) {
		return sql.selectOne(namespace + ".checkCart", cart);
	}

}
