package com.iot.spring.service.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iot.spring.dao.ConnectionDAO;
import com.iot.spring.dbcon.DBConnector;
import com.iot.spring.service.ConnectionService;
import com.iot.spring.vo.ConnectionInfoVO;
import com.iot.spring.vo.TableVO;

@Service
public class ConnectionServiceImpl implements ConnectionService {

	private static final Logger log = LoggerFactory.getLogger(ConnectionServiceImpl.class);
	
	@Autowired
	ConnectionDAO cDAO;
	
	@Override
	public List<ConnectionInfoVO> getConnectionList() { 
		return cDAO.selectConnectionInfoList();
	}

	@Override
	public void getConnectionInfo(ConnectionInfoVO ci) {
		cDAO.selectConnectionInfo(ci);
	}

	@Override
	public int insertConnectionInfo(ConnectionInfoVO ci) {
		return cDAO.insertConnectionInfo(ci);
	}

	@Override
	public List<Map<String, Object>> getDatabaseList() {
		List<Map<String, Object>> dbList=cDAO.selectDatabaseList();
		int idx=0;
		log.info("dbList =>{}",dbList);
		for(Map<String, Object> mDb:dbList) {
			mDb.put("id", mDb.get("ciNo"));
			mDb.put("text", mDb.get("ciDatabase"));
			mDb.put("items", new Object[] {});
		}
		System.out.println("dbList =>"+dbList);
		return dbList;
	}
	
	@Override
	public List<Map<String, Object>> getDatabaseList(HttpSession hs,int ciNo) throws Exception {
		ConnectionInfoVO ci=cDAO.selectConnectionInfo(ciNo);
		System.out.println(ci);
		hs.setAttribute("ci", ci);
		DBConnector dbc=new DBConnector(ci);
		SqlSession ss=dbc.getSqlSession();
		hs.setAttribute("sqlSession", ss);
		System.out.println(ss.selectList("connection.selectDatabase"));
		List<Map<String, Object>> dbList=cDAO.selectDatabaseList(ss);
		int idx=0;
		System.out.println("dbList"+dbList);
		for(Map<String,Object> dbMap : dbList) {
	         dbMap.put("id", ciNo + "_" + (++idx));
	         dbMap.put("text", dbMap.get("Database"));   
	         dbMap.put("items", new Object[] {});
	      }
		return dbList;
	}

	
	//각각의 테이블을 보여줌 3레벨
	@Override
	public List<TableVO> getTableList(HttpSession hs, String dbName) {
		SqlSession ss = (SqlSession)hs.getAttribute("sqlSession");
	    return cDAO.selectTableList(ss, dbName);
	}
	
	@Override
	public List<Map<String, Object>> getColmnsList(String resource){
		return cDAO.selectColmnsList(resource);
	}

	@Override
	public int updateConnectionInfo(ConnectionInfoVO ci) {
		// TODO Auto-generated method stub
		return cDAO.updateConnectionInfo(ci);
	}

	@Override
	public int deleteConnectionInfo(ConnectionInfoVO ci) {  
		// TODO Auto-generated method stub 
		return cDAO.deleteConnectionInfo(ci);
	}

}
