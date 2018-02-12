package com.iot.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iot.spring.service.UserService;
import com.iot.spring.vo.User;
import com.iot.spring.vo.UserVO;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private static final Logger log = LoggerFactory.getLogger(EmpController.class);
	
	@Autowired
	private UserService us;
	
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> SignupUser(@Valid UserVO ui, HttpSession hs ){
		log.info("Before Login HttpSession =>{}",hs.getAttribute("user"));
		Map<String,Object> map=new HashMap<String,Object>();
		us.signin(map, ui);
		log.info("After Login HttpSession =>{}",hs.getAttribute("user"));
		return map;
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> LoginUser(@Valid UserVO ui, HttpSession hs){
		log.info("Before Login HttpSession =>{}",hs.getAttribute("user"));
		ui=us.getUserInfo(ui);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("isLogin", false);
		map.put("msg", "로그인 실패");
		if(ui!=null) {
			hs.setAttribute("user", ui);
			hs.setAttribute("isLogin", true);
			map.put("loginOk", true);
			map.put("msg", "로그인 성공");
			if(ui.getAdmin()=='1') {
				hs.setAttribute("admin", "어드민 입니다");
			}
		}
		
		log.info("After Login HttpSession =>{}",hs.getAttribute("user"));

		return map;
	}
	
	@RequestMapping(value="list", method=RequestMethod.GET)
	public @ResponseBody List<UserVO> selectUserList(HttpSession hs) {
		UserVO ui =(UserVO) hs.getAttribute("user");
		return us.getUserInfoList(ui);
	}
	
	/*@RequestMapping(value="login", method=RequestMethod.GET)
	public String LoginUser(HttpServletRequest req,HttpServletResponse res) throws IOException {
		PrintWriter out=res.getWriter();
		if(req.getAttribute("param")==null) {
			return "user/login";
		}
		req.setAttribute("login", us.login(req, res));
		return "user/login";
	}*/
	
	/*@RequestMapping(value="list", method=RequestMethod.GET)
	public String selectUserList(HttpServletRequest req,HttpServletResponse res) throws IOException {
		us.getUserList(req);
		return "user/list";
	}*/
	
	@RequestMapping(value="lista", method=RequestMethod.GET)
	public @ResponseBody List<User> getUserListAjax(Model m) {
		return us.getUserList();
	}
}
