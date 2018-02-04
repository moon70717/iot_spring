package com.iot.spring.service;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iot.spring.vo.UserClass;

public interface UserService {

	public void getUserList(HttpServletRequest req);

	public HashMap<String, Object> login(HttpServletRequest req, HttpServletResponse res); 

	public void logout(HttpServletRequest req);

	public String signin(HttpServletRequest req);
	
	public String deleteUser(HttpServletRequest req);
	
	public String updateUser(HttpServletRequest req);
}
