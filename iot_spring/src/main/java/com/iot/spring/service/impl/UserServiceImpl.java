package com.iot.spring.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.iot.spring.controller.EmpController;
import com.iot.spring.dao.UserDAO;
import com.iot.spring.service.UserService;
import com.iot.spring.vo.User;
import com.iot.spring.vo.UserClass;
import com.iot.spring.vo.UserVO;

@Service
public class UserServiceImpl implements UserService {
	private Gson gs = new Gson();
	private static final Logger log = LoggerFactory.getLogger(EmpController.class);
	
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
		/*data=gs.toJson(data);*/
		req.setAttribute("dhtmlUserList", data);
	}
	
	@Override
	public List<User> getUserList() {
		return uDAO.selectUserA();
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
	public UserVO getUserInfo(UserVO ui) {
		// TODO Auto-generated method stub
		return uDAO.selectUserInfo(ui);
	}

	private boolean isDuplUserInfo(UserVO ui) {
		if(uDAO.checkUserInfo(ui)==1) {
			return true;
		}
		return false;
	}
	
	@Override
	public void signin(Map<String, Object> rMap, UserVO ui) {
		if(isDuplUserInfo(ui)) {
			rMap.put("msg", ui.getuName()+"은 이미 존재하는 이름입니다");
			return;
		}
		int result=uDAO.insertUser(ui);
		rMap.put("msg", "회원가입 실패");
		rMap.put("signupOk", false);
		if(result==1) {
			rMap.put("msg", "회원가입 성공");
			rMap.put("signupOk", true);
		}
	}

	@Override
	public List<UserVO> getUserInfoList(UserVO ui) {
		return uDAO.selectUserInfoList(ui);
	}

}
