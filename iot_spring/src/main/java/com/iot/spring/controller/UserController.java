package com.iot.spring.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iot.spring.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(EmpController.class);
	
	@Autowired
	private UserService us;
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String LoginUser(HttpServletRequest req,HttpServletResponse res) throws IOException {
		PrintWriter out=res.getWriter();
		if(req.getAttribute("param")==null) {
			return "user/login";
		}
		req.setAttribute("login", us.login(req, res));
		return "user/login";
	}
	
	@RequestMapping(value="list", method=RequestMethod.GET)
	public String selectUserList(HttpServletRequest req,HttpServletResponse res) throws IOException {
		us.getUserList(req);
		return "user/list";
	}
}
