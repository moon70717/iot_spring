package si.mp.le.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import si.mp.le.user.DAO.UserDAO;
import si.mp.le.user.vo.User;

@Component
public class UserService {
	@Autowired
	private UserDAO uDAO;
	
	public User getUser() {
		return uDAO.selectUser();
	}
	
	public List<User> getUserList() {
		return uDAO.selectUserList();
	}
	
	public int insertUser() {
		return uDAO.insertUser();
	}
}
