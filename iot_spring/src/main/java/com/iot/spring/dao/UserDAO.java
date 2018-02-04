package com.iot.spring.dao;

import java.util.List;

import com.iot.spring.User;
import com.iot.spring.vo.UserClass;

public interface UserDAO {

	public User selectUser(UserClass uc); 
	
	public List<UserClass> selectUserList();
}
