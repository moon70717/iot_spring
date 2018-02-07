package com.iot.spring.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.iot.spring.dao.ConnectionDAO;
import com.iot.spring.vo.ConnectionInfoVO;

@Component
public class ConnectionDAOImpl implements ConnectionDAO {

	@Autowired
	private SqlSessionFactory ssf;
	
	@Override
	public List<ConnectionInfoVO> selectConnectionInfoList() {
		SqlSession ss=ssf.openSession();
		return ss.selectList("connection.selectConnectionList");
	}
	
	@Override
	public ConnectionInfoVO selectConnectionInfo(ConnectionInfoVO ci) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertConnectionInfo(ConnectionInfoVO ci) {
		SqlSession ss=ssf.openSession();
		int result=ss.insert("connection.insertConnectionInfo", ci);
		ss.close();
		return result;
	}

}
