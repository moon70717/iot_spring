package com.iot.spring.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iot.spring.service.SqlService;

@Controller
@RequestMapping("/sqls")
public class SqlController {

	private static final Logger log = LoggerFactory.getLogger(SqlController.class);

	@Autowired
	SqlService sis;

	// 커스텀 sql
	// 개판이니깐 수정필수
	// 여러개 돌아가게 split으로 나누자
	// ;기준으로 나누면 될듯
	// 근데 어떻게 넣을까
	// result에 여러개를 넣는 방법도 있긴 하지만 좀 지저분할듯
	@RequestMapping("/custom/{lastDb}")
	public @ResponseBody Map<String, Object> runCustomSql(@PathVariable("lastDb") String lastDb, 
			@RequestParam("sql") String sql, Map<String, Object> map, HttpSession hs) {
		List<List<Map<String, Object>>> result = sis.RunCustom(hs, sql, lastDb);
		log.info("result =>{}", result);
		map.put("result", result);
		return map;
	}
	
	@RequestMapping(value= "/test", method=RequestMethod.GET)
	public @ResponseBody String AjaxView(  
	        @RequestParam("id") String id)  {
	    return id;
	}
}
