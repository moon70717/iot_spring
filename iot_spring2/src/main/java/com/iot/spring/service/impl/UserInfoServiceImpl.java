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
		ui = uDAO.selectUserInfo(ui);
		rMap.put("msg", "아이디 비밀번호를 확인해주세요");
		rMap.put("biz", false);
		if (ui != null) {
			rMap.put("msg", ui.getuName() + "님 로그인에 성공하셨습니다");
			rMap.put("biz", true);
			rMap.put("user", ui);
			return true;
		}

		return false;
	}

	
	// 0:실패 1:성공 2:아이디중복
	@Override
	public boolean join(Map<String, Object> rMap, UserInfoVO ui) {
		rMap.put("msg", "회원가입 실패");
		rMap.put("biz", false);
		if(uDAO.validUserId(ui) != 0) {
			rMap.put("msg", "아이디가 중복되었습니다");
			return false;
		}
		if (uDAO.insertUserInfo(ui) == 1) {
			rMap.put("msg", "회원가입 성공");
			rMap.put("biz", true);
			return true;
		}
		return false;
	}


	@Override
	public int checkuserId(String uId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
