package com.iot.spring.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iot.spring.User;
import com.iot.spring.dao.UserDAO;
import com.iot.spring.vo.Emp;
import com.iot.spring.vo.UserClass;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SqlSessionFactory ssf;
	
	@Override
	public User selectUser(UserClass uc) {
		SqlSession ss=ssf.openSession();
		return (User) ss.selectList("user.findUser", uc);
	}

	@Override
	public List<UserClass> selectUserList() {
		SqlSession ss=ssf.openSession();
		List<UserClass> userList=ss.selectList("user.selectUser");
		return userList;
	}

}
