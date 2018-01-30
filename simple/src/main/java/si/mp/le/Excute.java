package si.mp.le;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import si.mp.le.service.UserService;
import si.mp.le.vo.User;

public class Excute {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("ioc.xml");

		UserService us = (UserService) ac.getBean("userService");
		System.out.println(us.getUser());

		List<User> userList = us.getUserList();

		for (User u : userList) {
			System.out.println(u.getUiName());
		}

	}
}
