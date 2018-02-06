package com.iot.spring.dao;

import java.util.List;

import com.iot.spring.vo.User;
import com.iot.spring.vo.UserClass;

public interface UserDAO {

	public UserClass selectUser(UserClass uc);
	
	public UserClass selectUser(int uiNo);
	
	public List<User> selectUserA();
	
	public List<UserClass> selectUserList();
}
