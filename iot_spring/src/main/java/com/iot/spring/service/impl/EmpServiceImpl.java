package com.iot.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iot.spring.dao.EmpDAO;
import com.iot.spring.service.EmpService;
import com.iot.spring.vo.Emp;

@Service
public class EmpServiceImpl implements EmpService {
	
	@Autowired
	private EmpDAO edao;
	
	@Override
	public List<Emp> getEmpList() {
		return edao.selectEmpList();
	}

	@Override
	public Emp getEmp() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertEmp(Emp e) {
		return edao.insertEmp(e);
	}

	@Override
	public int updateEmp() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteEmp() {
		// TODO Auto-generated method stub
		return 0;
	}

}
