package com.iot.spring.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.iot.spring.vo.ConnectionInfoVO;
import com.iot.spring.vo.TableVO;

public interface ConnectionService {

	public List<ConnectionInfoVO> getConnectionList();
	
	public void getConnectionInfo(ConnectionInfoVO ci);
	
	public int insertConnectionInfo(ConnectionInfoVO ci);
	
	public List<Map<String,Object>> getDatabaseList();
	
	public List<Map<String,Object>> getDatabaseList(HttpSession hs,int ciNo) throws Exception;
	
	public List<TableVO> getTableList(String dbName);
	
	public List<Map<String, Object>> getColmnsList(String resource);
	
	public int updateConnectionInfo(ConnectionInfoVO ci);
	
	public int deleteConnectionInfo(ConnectionInfoVO ci);
}
