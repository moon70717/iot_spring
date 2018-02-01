package com.iot.spring.user.DAO;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.iot.spring.user.vo.Emp;

public class UserDAO {

	private JdbcTemplate jt;
	
	public void setJdbcTemplate(JdbcTemplate jt) {
		this.jt=jt;
	}
	
	public List<Emp> getUser(){
		String sql="select * from emp";
		
		return null;
	}
	
}
