package com.iot.spring.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.iot.spring.dao.UserDAO;
import com.iot.spring.vo.User;
import com.iot.spring.vo.UserClass;
import com.iot.spring.vo.UserVO;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	@Qualifier("iot2Ssf")
	private SqlSessionFactory ssf;
	
	@Autowired
	@Qualifier("dbConnectorSsf")
	private SqlSessionFactory ssf2;
	
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

	@Override
	public UserVO selectUserInfo(UserVO ui) {
		final SqlSession ss=ssf2.openSession();
		UserVO uVo=ss.selectOne("user.selectUserInfo",ui);
		ss.close();
		return uVo;
	}

	@Override
	public int insertUser(UserVO ui) {
		final SqlSession ss=ssf2.openSession();
		int result=ss.insert("user.insertUserInfo",ui);
		ss.close();
		return result;
	}

	@Override
	public int checkUserInfo(UserVO ui) {
		final SqlSession ss=ssf2.openSession();
		int result=ss.selectOne("user.selectUser",ui);
		ss.close();
		return result;
	}

	@Override
	public List<UserVO> selectUserInfoList(UserVO ui) {
		final SqlSession ss=ssf2.openSession();
		List<UserVO> result=ss.selectList("user.selectUserInfo",ui);
		ss.close();
		return result;
	}

}
