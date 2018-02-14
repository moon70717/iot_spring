package com.iot.spring.DAO.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iot.spring.DAO.ConnectionInfoDAO;
import com.iot.spring.vo.ConnectionInfoVO;
import com.iot.spring.vo.UserInfoVO;

@Repository
public class ConnectionInfoDAOImpl implements ConnectionInfoDAO {

	@Autowired
	private SqlSessionFactory ssf;
	
	
	//로그인한 아이디에따른 커넥션 리스트를 받아옴
	@Override
	public List<Map<String, Object>> selectConnectionInfoList(UserInfoVO ui) {
		SqlSession ss=ssf.openSession();
		List<Map<String, Object>> result=ss.selectList("connection.selectConnectionList",ui.getuId());
		ss.close();
		return result;
	}

	//커넥션 정보 받아옴
	@Override
	public ConnectionInfoVO selectConnectionInfo(int ciNo) {
		SqlSession ss=ssf.openSession();
		ConnectionInfoVO ci=ss.selectOne("connection.selectConnection",ciNo);
		ss.close();
		return ci;
	}

	
	//데이터베이스 정보 받아옴
	@Override
	public List<Map<String, Object>> selectDatabaseList(SqlSession ss) {
		return ss.selectList("connection.selectDatabaseList");
	}

	//선택한 데이터 베이스의 테이블 정보를 받아옴
	@Override
	public List<Map<String, Object>> selectTableList(SqlSession ss, String dbName) {
		return ss.selectList("connection.selectTableList",dbName);
	}
}
