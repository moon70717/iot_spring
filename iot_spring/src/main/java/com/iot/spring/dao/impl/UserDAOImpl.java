package com.iot.spring.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iot.spring.dao.UserDAO;
import com.iot.spring.vo.User;
import com.iot.spring.vo.UserClass;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SqlSessionFactory ssf;
	
	@Override
	public UserClass selectUser(UserClass uc) {
		SqlSession ss=ssf.openSession();
		return (UserClass) ss.selectList("user.findUser", uc);
	}

	@Override
	public List<UserClass> selectUserList() {
		SqlSession ss=ssf.openSession();
		return ss.selectList("user.selectUserList");
	}

	@Override
	public List<User> selectUserA() {
		SqlSession ss=ssf.openSession();
		List<User> userList=ss.selectList("user.selectUser");
		return userList;
	}
	
	@Override
	public UserClass selectUser(int uiNo) {
		
		return null;
	}

}
