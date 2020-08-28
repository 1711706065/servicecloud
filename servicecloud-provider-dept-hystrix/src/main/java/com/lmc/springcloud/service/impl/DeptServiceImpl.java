package com.lmc.springcloud.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lmc.springcloud.dao.DeptDao;
import com.lmc.springcloud.entities.Dept;
import com.lmc.springcloud.service.DeptService;

@Service("deptService")
public class DeptServiceImpl implements DeptService {

	@Autowired
	private DeptDao deptDao;
	
	@Override
	public boolean add(Dept dept) {
		// TODO Auto-generated method stub
		return deptDao.addDept(dept);
	}

	@Override
	public Dept get(Long id) {
		// TODO Auto-generated method stub
		return deptDao.findById(id);
	}

	@Override
	public List<Dept> list() {
		// TODO Auto-generated method stub
		return deptDao.findAll();
	}

}
