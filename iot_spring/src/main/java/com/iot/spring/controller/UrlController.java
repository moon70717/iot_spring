package com.iot.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iot.spring.HomeController;

@Controller
@RequestMapping("/path")
public class UrlController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	private String getUrl(String url,String rootPath) {
		return url.replace(rootPath+"/path", "");
	}
	
	@RequestMapping("/**")
	public String forwardJsp(HttpServletRequest req) {
		String url=req.getRequestURI();
		String rootPath=req.getContextPath();
		url=getUrl(url,rootPath);
		logger.info("path=>{}",url);
		return url;
	}
}
