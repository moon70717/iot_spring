package com.iot.spring.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.iot.spring.dao.ConnectionDAO;
import com.iot.spring.vo.ConnectionInfoVO;
import com.iot.spring.vo.TableVO;

@Component
public class ConnectionDAOImpl implements ConnectionDAO {

	private static final Logger log = LoggerFactory.getLogger(ConnectionDAOImpl.class);
	
	@Autowired
	@Qualifier("dbConnectorSsf")
	private SqlSessionFactory ssf;

	//번호에따라 커넥션 리스트를 받아옴
	@Override
	public ConnectionInfoVO selectConnectionInfo(int ciNo) {
		SqlSession ss = ssf.openSession();
		
		System.out.println(ciNo);
		ConnectionInfoVO ci = ss.selectOne("connection.selectConnectionListWithCiNo", ciNo);
		ss.close();
		return ci;
	}
	
	@Override
	public List<ConnectionInfoVO> selectConnectionInfoList() {
		SqlSession ss = ssf.openSession();
		return ss.selectList("connection.selectConnectionList");
	}

	@Override
	public ConnectionInfoVO selectConnectionInfo(ConnectionInfoVO ci) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertConnectionInfo(ConnectionInfoVO ci) {
		SqlSession ss = ssf.openSession();
		int result = ss.insert("connection.insertConnectionInfo", ci);
		ss.close();
		return result;
	}

	
	//트리맵 1레벨용
	@Override
	public List<Map<String, Object>> selectDatabaseList() {
		List<Map<String, Object>> result = null;
		SqlSession ss = ssf.openSession();
		result = ss.selectList("connection.selectConnectionList");
		log.info("result =>{}",result);
		ss.close();
		return result;
	}

	//트리맵 2레벨용
	@Override
	public List<Map<String, Object>> selectDatabaseList(SqlSession ss) throws Exception {
		List<Map<String, Object>> map=ss.selectList("connection.selectDatabase");
		return map;
	}

	//트리맵 3레벨용
	@Override
	public List<TableVO> selectTableList(SqlSession ss, String dbName) {
		 List<TableVO> result = null;
	      result = ss.selectList("connection.selectTable",dbName);
	      return result;
	}

	@Override
	public List<Map<String, Object>> selectColmnsList(String resource) {
		List<Map<String, Object>> result = null;
		SqlSession ss = ssf.openSession();
		result = ss.selectList("connection.selectColumns", resource);
		ss.close();
		return result;
	}

	@Override
	public int updateConnectionInfo(ConnectionInfoVO ci) {
		int result = 0;
		SqlSession ss = ssf.openSession();
		result = ss.update("connection.updateConnectionInfo", ci);
		ss.close();
		return result;
	}

	@Override
	public int deleteConnectionInfo(ConnectionInfoVO ci) {
		int result = 0;
		SqlSession ss = ssf.openSession();
		result = ss.update("connection.deleteConnectionInfo", ci);
		ss.close();
		return result;
	}

}
