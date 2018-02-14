package com.iot.spring.DAO.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iot.spring.DAO.UserInfoDAO;
import com.iot.spring.vo.UserInfoVO;

@Repository
public class UserInfoDAOImpl implements UserInfoDAO {

	@Autowired
	private SqlSessionFactory ssf;

	@Override
	public UserInfoVO selectUserInfo(UserInfoVO ui) {
		SqlSession ss = ssf.openSession();
		ui = ss.selectOne("user.selectUserInfo", ui);
		ss.close();
		return ui;
	}

	@Override
	public int insertUserInfo(UserInfoVO ui) {
		SqlSession ss = ssf.openSession();
		int result = ss.insert("user.insertUserInfo", ui);
		ss.close();
		return result;
	}

	@Override
	public int validUserId(UserInfoVO ui) {
		SqlSession ss = ssf.openSession();
		int result = ss.selectOne("user.vaildId", ui);
		return result;
	}
	
	public List<UserInfoVO> selectUserInfoList(){
		SqlSession ss=ssf.openSession();
		List<UserInfoVO> result=ss.selectList("user.selectUserInfoList");
		return null;
	}

}
