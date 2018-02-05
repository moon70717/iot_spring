package com.iot.spring.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.iot.spring.dao.UserDAO;
import com.iot.spring.service.UserService;
import com.iot.spring.vo.UserClass;

@Service
public class UserServiceImpl implements UserService {
	private Gson gs = new Gson();
	
	@Autowired
	private UserDAO uDAO;
	
	@Override
	public void getUserList(HttpServletRequest req) {
		List<UserClass> userList=uDAO.selectUserList();
		String data="{rows : [ ";
		int idx=1;
		for(UserClass u:userList) {
			data+=u.dhtmlJson();
			idx++;
			if(userList.size()>=idx) {
				data+=",";
			}
		} 
		data+="]}";
		req.setAttribute("userList", data);
	}

	@Override
	public HashMap<String, Object> login(HttpServletRequest req, HttpServletResponse res) {
		UserClass uc=gs.fromJson(req.getParameter("param"), UserClass.class);
		System.out.println("uc "+uc);
		HashMap<String, Object> result = null;
		result.put("login", "실패");
		if(uc.getUiId()!=null) {
			result.put("login", "ok");
			req.setAttribute("user", uc);
		}
		return result;
	}

	@Override
	public void logout(HttpServletRequest req) {
		// TODO Auto-generated method stub

	}

	@Override
	public String signin(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteUser(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateUser(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

}
