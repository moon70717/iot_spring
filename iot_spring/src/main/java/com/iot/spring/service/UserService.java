package com.iot.spring.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iot.spring.vo.User;

public interface UserService {

	public void getUserList(HttpServletRequest req);

	public List<User> getUserList();

	public HashMap<String, Object> login(HttpServletRequest req, HttpServletResponse res);

	public void logout(HttpServletRequest req);

	public String signin(HttpServletRequest req);

	public String deleteUser(HttpServletRequest req);

	public String updateUser(HttpServletRequest req);
}
