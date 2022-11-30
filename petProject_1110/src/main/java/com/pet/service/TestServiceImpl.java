package com.pet.service;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.pet.dao.TestDao;

@Service
public class TestServiceImpl implements TestService{
	
	@Inject
	TestDao testDao;
	
	@Override
	public List<HashMap> list() throws Exception {
		// TODO Auto-generated method stub
		return testDao.list();
	}

}
