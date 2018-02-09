package com.iot.spring.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iot.spring.dao.ConnectionDAO;
import com.iot.spring.service.ConnectionService;
import com.iot.spring.vo.ConnectionInfoVO;
import com.iot.spring.vo.TableVO;

@Service
public class ConnectionServiceImpl implements ConnectionService {

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
		for(Map<String,Object> mDb:dbList) {
			mDb.put("id", ++idx);
			mDb.put("text", mDb.get("Database"));
			mDb.put("items", new Object[] {});
		}
		return dbList;
	}

	@Override
	public List<TableVO> getTableList(String dbName) {
		return cDAO.selectTableList(dbName);
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
