package com.iot.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.iot.spring.vo.Emp;


@Service
public interface EmpService {

	public List<Emp> getEmpList();
	public Emp getEmp();
	public int insertEmp(Emp e);
	public int updateEmp();
	public int deleteEmp();
}
