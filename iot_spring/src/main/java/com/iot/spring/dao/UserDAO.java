package com.iot.spring.dao;

import java.util.List;

import com.iot.spring.vo.User;
import com.iot.spring.vo.UserClass;
import com.iot.spring.vo.UserVO;

public interface UserDAO {

	UserClass selectUser(UserClass uc);
	
	UserClass selectUser(int uiNo);
	
	List<User> selectUserA();
	
	List<UserClass> selectUserList();
	
	UserVO selectUserInfo(UserVO ui);
	
	int insertUser(UserVO ui);
	
	int checkUserInfo(UserVO ui);
	
	List<UserVO> selectUserInfoList(UserVO ui);
}
