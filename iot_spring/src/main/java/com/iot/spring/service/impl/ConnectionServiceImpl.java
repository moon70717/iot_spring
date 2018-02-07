package com.iot.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iot.spring.dao.ConnectionDAO;
import com.iot.spring.service.ConnectionService;
import com.iot.spring.vo.ConnectionInfoVO;

@Service
public class ConnectionServiceImpl implements ConnectionService {

	@Autowired
	ConnectionDAO cDAO;
	
	@Override
	public void getConnectionList() {
		cDAO.selectConnectionInfoList();
	}

	@Override
	public void getConnectionInfo(ConnectionInfoVO ci) {
		cDAO.selectConnectionInfo(ci);
	}

	@Override
	public int insertConnectionInfo(ConnectionInfoVO ci) {
		return cDAO.insertConnectionInfo(ci);
	}

}
