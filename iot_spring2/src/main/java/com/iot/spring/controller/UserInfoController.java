package com.iot.spring.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iot.spring.service.UserInfoService;
import com.iot.spring.vo.UserInfoVO;

@Controller
@RequestMapping("/user")
public class UserInfoController {


	@Autowired
	private UserInfoService uis;
	
	private static final Logger log = LoggerFactory.getLogger(UserInfoController.class);
	
	@RequestMapping("/login")
	public @ResponseBody Map<String, Object> login(UserInfoVO ui, HttpSession hs){
		Map<String,Object> map=new HashMap<String,Object>(); 
		
		if(uis.login(map, ui)) {
			hs.setAttribute("user", map.get("user"));
		}
		log.info("returnMap=>{}",map);
		return map;
	}
	
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> join(@RequestBody UserInfoVO ui){
		Map<String,Object> map=new HashMap<String,Object>();
		log.info("insertUi=>{}",ui);
		uis.join(map, ui);
		return map;
	}
	
	@RequestMapping(value="/join2", method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> join2(@RequestParam UserInfoVO ui){
		Map<String,Object> map=new HashMap<String,Object>();
		log.info("insertUi=>{}",ui);
		map.put("", "gd");
		return map;
	}
}
