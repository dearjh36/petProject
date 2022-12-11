package com.pet.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pet.model.OrderDTO;

@Repository
public class OrderDaoImpl implements OrderDao {

	@Autowired
	private SqlSession sql;

	private static String namespace = "com.pet.mapper.OrderMapper";

	@Override
	public void insertPOrder(OrderDTO dto) throws Exception {
		sql.insert(namespace + ".insertPOrder", dto);
	}

	@Override
	public int getONum() throws Exception {
		return sql.selectOne(namespace + ".getONum");
	}

	@Override
	public void insertODetail(OrderDTO dto) throws Exception {
		sql.insert(namespace+".insertODetail", dto);
	}

	@Override
	public List<OrderDTO> orderList(int oNum, String id) throws Exception {
		
		HashMap<Object, Object> data = new HashMap<Object, Object>();
		
		data.put("oNum", oNum);
		data.put("id", id);
		
		return sql.selectList(namespace+".orderList", data);
	}

	@Override
	public List<Integer> ONumList(String id) throws Exception {
		return sql.selectList(namespace+".ONumList",id);
	}

}
