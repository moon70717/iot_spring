package com.iot.spring;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		model.addAttribute("test","테테테스트");
		model.addAttribute("text","테테텍스트");
		
		return "home";
	}
	
	@RequestMapping(value = "/h", method = RequestMethod.GET)
	public String home1(Locale locale, Model model) {
		model.addAttribute("test","테테테스트");
		model.addAttribute("text","테테텍스트");
		
		return "home2";
	}
	@RequestMapping(value = "/h2", method = RequestMethod.GET)
	@ResponseBody
	public List<User> home2() {
		User user=new User();
		List<User> list=new ArrayList<User>();
		user.setName("홍길동");
		user.setAge(33); 
		list.add(user);
		list.add(user);
		list.add(user);
		list.add(user);
		list.add(user);
		return list;
	}
	
}
