package si.mp.le.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import si.mp.le.DAO.UserDAO;
import si.mp.le.vo.User;

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
}
