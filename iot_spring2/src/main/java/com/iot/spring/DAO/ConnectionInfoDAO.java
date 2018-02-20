package com.iot.spring.DAO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.iot.spring.vo.ConnectionInfoVO;
import com.iot.spring.vo.UserInfoVO;

public interface ConnectionInfoDAO {

	List<Map<String, Object>> selectConnectionInfoList(UserInfoVO ui);
	
	ConnectionInfoVO selectConnectionInfo(int ciNo);
	
	List<Map<String,Object>> selectDatabaseList(SqlSession ss);
	
	List<Map<String,Object>> selectTableList(SqlSession ss, String dbName);
	
	List<Map<String,Object>> selectTableInfo(SqlSession ss, String tbName);
	
	List<Map<String,Object>> selectTableDesc(SqlSession ss, String tbName);
}
