package com.iot.spring.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.iot.spring.vo.ConnectionInfoVO;
import com.iot.spring.vo.TableVO;

public interface ConnectionDAO {

	public ConnectionInfoVO selectConnectionInfo(int ciNo);
	
	public List<ConnectionInfoVO> selectConnectionInfoList();
	
	public ConnectionInfoVO selectConnectionInfo(ConnectionInfoVO ci);
	
	public int insertConnectionInfo(ConnectionInfoVO ci);
	
	public List<Map<String,Object>> selectDatabaseList();
	
	public List<Map<String,Object>> selectDatabaseList(SqlSession ss) throws Exception;
	
	public List<TableVO> selectTableList(String dbName);
	
	public List<Map<String,Object>> selectColmnsList(String resource);
	
	public int updateConnectionInfo(ConnectionInfoVO ci);
	
	public int deleteConnectionInfo(ConnectionInfoVO ci);
}
