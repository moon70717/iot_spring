package com.iot.spring.service;

import com.iot.spring.vo.ConnectionInfoVO;

public interface ConnectionService {

	public void getConnectionList();
	
	public void getConnectionInfo(ConnectionInfoVO ci);
	
	public int insertConnectionInfo(ConnectionInfoVO ci);
}
