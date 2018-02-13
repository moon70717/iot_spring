package com.iot.spring.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iot.spring.DAO.UserInfoDAO;
import com.iot.spring.service.UserInfoService;
import com.iot.spring.vo.UserInfoVO;

@Service
public class UserInfoServiceImpl implements UserInfoService {
	
	@Autowired
	private UserInfoDAO uDAO;
	
	@Override
	public boolean login(Map<String, Object> rMap, UserInfoVO ui) {
		ui=uDAO.selectUserInfo(ui);
		rMap.put("msg", "아이디 비밀번호를 확인해주세요");
		rMap.put("biz", false);
		if(ui!=null) {
			rMap.put("msg", ui.getuName()+"님 로그인에 성공하셨습니다");
			rMap.put("biz", true);
			rMap.put("user", ui);
			return true;
		}
		
		return false;
	}

}
