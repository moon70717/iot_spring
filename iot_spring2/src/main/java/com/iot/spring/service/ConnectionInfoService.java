package com.iot.spring.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.iot.spring.vo.UserInfoVO;

public interface ConnectionInfoService {

	List<Map<String,Object>> getConnectionInfoList(UserInfoVO ui);
	
	List<Map<String,Object>> getDatabaseList(int ciNo, HttpSession hs) throws Exception;
	
	List<Map<String,Object>> getTableList(HttpSession hs, String dbName);
	
	List<Map<String,Object>> getTableInfo(HttpSession hs, String dbName);
	
	List<Map<String,Object>> descTableInfo(HttpSession hs, String dbName);
	
	List<Map<String,Object>> RunCustom(HttpSession hs, String sql, String lastDb);
	
}
