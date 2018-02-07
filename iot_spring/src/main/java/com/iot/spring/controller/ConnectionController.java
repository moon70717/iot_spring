package com.iot.spring.controller;

import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iot.spring.service.ConnectionService;
import com.iot.spring.vo.ConnectionInfoVO;

@Controller
@RequestMapping("/connection")
public class ConnectionController {

	private static final Logger log = LoggerFactory.getLogger(EmpController.class);
	
	@Autowired
	ConnectionService cs;
	
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public @ResponseBody Map insertConnection(@RequestParam Map map) {
		ObjectMapper om=new ObjectMapper();
		ConnectionInfoVO ci=om.convertValue(map, ConnectionInfoVO.class);
		int result=cs.insertConnectionInfo(ci);
		map.put("msg", "실패");
		if(result==1) {
			map.put("msg", "성공");
		}
		log.info("requsetMap=>{}",map);
		return map;
	}
}
