package com.pet.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pet.model.MemberVO;
import com.pet.model.MtmVO;
import com.pet.model.OrderDTO;
import com.pet.model.ProductVO;

@Repository
public class AdminDaoImpl implements AdminDao {

	@Autowired
	private SqlSession sql;

	private static String namespace = "com.pet.mapper.AdminMapper";

	// 상품 등록
	@Override
	public void insertProduct(ProductVO vo) throws Exception {
		sql.insert(namespace + ".insertProduct", vo);
	}

	@Override
	public List<OrderDTO> adminOrderList(String id) throws Exception {
		return sql.selectList(namespace + ".adminOrderList", id);
	}

	@Override
	public void updateFinishOrderResult(int odNum) throws Exception {
		sql.update(namespace + ".updateFinishOrderResult", odNum);
	}

	@Override
	public void updateOrderResult(int odNum) throws Exception {
		sql.update(namespace + ".updateOrderResult", odNum);
	}

	@Override
	public List<OrderDTO> cancelListOrder(String id) throws Exception {
		return sql.selectList(namespace + ".cancelListOrder", id);
	}
	
	@Override
	public List<OrderDTO> PriceRank(String key) throws Exception {
		return sql.selectList(namespace + ".PriceRank");
	}

	@Override
	public List<MemberVO> memberList(String name) throws Exception {
		return sql.selectList(namespace + ".memberList", name);
	}

	@Override
	public List<MtmVO> listAllMtm() throws Exception {
		return sql.selectList(namespace+".listAllMtm");
	}

}
