package com.iot.spring.dao;

import java.util.List;

import com.iot.spring.vo.ConnectionInfoVO;

public interface ConnectionDAO {

	public List<ConnectionInfoVO> selectConnectionInfoList();
	
	public ConnectionInfoVO selectConnectionInfo(ConnectionInfoVO ci);
	
	public int insertConnectionInfo(ConnectionInfoVO ci);
}
