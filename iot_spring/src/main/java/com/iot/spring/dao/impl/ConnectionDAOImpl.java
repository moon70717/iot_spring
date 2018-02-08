package com.iot.spring.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.iot.spring.dao.ConnectionDAO;
import com.iot.spring.vo.ConnectionInfoVO;
import com.iot.spring.vo.TableVO;

@Component
public class ConnectionDAOImpl implements ConnectionDAO {

	@Autowired
	@Qualifier("dbConnectorSsf")
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

	@Override
	public List<Map<String, Object>> selectDatabaseList() {
		List<Map<String, Object>> result=null;
		SqlSession ss=ssf.openSession();
		result=ss.selectList("connection.selectDatabase");
		ss.close();
		return result;
	}

	@Override
	public List<TableVO> selectTableList(String dbName) {
		List<TableVO> result=null;
		SqlSession ss=ssf.openSession();
		result=ss.selectList("connection.selectTable",dbName);
		ss.close();
		return result;
	}

	@Override
	public List<Map<String, Object>> selectColmnsList(String resource) {
		List<Map<String, Object>> result=null;
		SqlSession ss=ssf.openSession();
		result=ss.selectList("connection.selectColumns",resource);
		ss.close();
		return result;
	}

}
