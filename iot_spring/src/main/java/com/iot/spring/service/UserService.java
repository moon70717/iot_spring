package com.iot.spring.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iot.spring.vo.User;
import com.iot.spring.vo.UserVO;

public interface UserService {

	UserVO getUserInfo(UserVO ui);
	
	void getUserList(HttpServletRequest req);

	List<User> getUserList();

	HashMap<String, Object> login(HttpServletRequest req, HttpServletResponse res);

	void signin(Map<String,Object> rMap, UserVO ui);
	
	List<UserVO> getUserInfoList(UserVO ui);
}
