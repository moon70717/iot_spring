package com.iot.spring.service.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iot.spring.DAO.ConnectionInfoDAO;
import com.iot.spring.service.ConnectionInfoService;
import com.iot.spring.utils.dbcon.DBConnector;
import com.iot.spring.vo.ConnectionInfoVO;
import com.iot.spring.vo.UserInfoVO;

@Service
public class ConnectionInfoServiceImpl implements ConnectionInfoService {

	@Autowired
	ConnectionInfoDAO cDAO;

	// 커넥션을 받아오고 dhtmlx에서 사용할수있도록 수정함
	@Override
	public List<Map<String, Object>> getConnectionInfoList(UserInfoVO ui) {
		List<Map<String, Object>> dbList = cDAO.selectConnectionInfoList(ui);
		for (Map<String, Object> mDb : dbList) {
			mDb.put("id", mDb.get("ciNo"));
			mDb.put("text", mDb.get("ciDatabase"));
			mDb.put("items", new Object[] {});
		}
		return dbList;
	}

	// 1. 해당하는 번호에따른 커넥션 정보를 받아옴
	// 2. 그 커넥션 정보로 db커넥터를 만든뒤 sql세션을 만들어서 저장함
	// 3. 그뒤 그것으로 데이타베이스 리스트를 받은뒤 가공함
	@Override
	public List<Map<String, Object>> getDatabaseList(int ciNo, HttpSession hs) throws Exception {
		ConnectionInfoVO ci = cDAO.selectConnectionInfo(ciNo);
		DBConnector dbc = new DBConnector(ci);
		SqlSession ss = dbc.getSqlSession();
		hs.setAttribute("SqlSession", ss);
		List<Map<String, Object>> dbList = cDAO.selectDatabaseList(ss);
		int idx = 0;
		for (Map<String, Object> dbMap : dbList) {
			dbMap.put("id", ciNo + "_" + (++idx));
			dbMap.put("text", dbMap.get("Database"));
			dbMap.put("items", new Object[] {});
		}
		return dbList;
	}

	// 선택한 데이터베이스의 테이블 정보를 받아옴
	@Override
	public List<Map<String, Object>> getTableList(HttpSession hs, String dbName) {
		SqlSession ss = (SqlSession) hs.getAttribute("SqlSession");
		return cDAO.selectTableList(ss, dbName);
	}

	// 선택한 테이블의 정보를 받아옴
	@Override
	public List<Map<String, Object>> getTableInfo(HttpSession hs, String tbName) {
		SqlSession ss = (SqlSession) hs.getAttribute("SqlSession");
		return cDAO.selectTableInfo(ss, tbName);
	}

	// 선택한 테이블의 정보를 받아옴(desc)
	@Override
	public List<Map<String, Object>> descTableInfo(HttpSession hs, String tbName) {
		SqlSession ss = (SqlSession) hs.getAttribute("SqlSession");
		return cDAO.selectTableDesc(ss, tbName);
	}

	@Override
	public int insertConnectionInfo(Map<String, Object> ci) {
		return cDAO.insertConnectionInfo(ci);
	}

}
