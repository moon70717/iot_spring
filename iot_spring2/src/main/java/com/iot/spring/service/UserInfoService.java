package com.iot.spring.service;

import java.util.Map;

import com.iot.spring.vo.UserInfoVO;

public interface UserInfoService {

	public boolean login(Map<String,Object> rMap, UserInfoVO ui);
	
	public boolean join(Map<String,Object> rMap, UserInfoVO ui);
	
	public int checkuserId(String uId);
}