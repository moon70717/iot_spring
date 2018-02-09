package com.iot.spring.controller;

import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iot.spring.service.ConnectionService;
import com.iot.spring.vo.ConnectionInfoVO;
import com.iot.spring.vo.TableVO;

@Controller
@RequestMapping("/connection")
public class ConnectionController {

	private static final Logger log = LoggerFactory.getLogger(EmpController.class);
	
	@Autowired
	ConnectionService cs;
	
	
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> insertConnection(@RequestParam Map<String, Object> map) {
		ObjectMapper om=new ObjectMapper();
		ConnectionInfoVO ci=om.convertValue(map, ConnectionInfoVO.class);
		int result=cs.insertConnectionInfo(ci);
		map.clear();
		map.put("msg", "실패");
		if(result==1) {
			map.put("msg", "성공");
		}
		log.info("requsetMap=>{}",map);
		return map;
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> updateConnection(@RequestParam Map<String, Object> map) {
		ObjectMapper om=new ObjectMapper();
		ConnectionInfoVO ci=om.convertValue(map, ConnectionInfoVO.class);
		int result=cs.updateConnectionInfo(ci);
		map.clear();
		map.put("msg", "실패");
		if(result==1) {
			map.put("msg", "성공");
		}
		log.info("requsetMap=>{}",map);
		return map;
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> deleteConnection(@RequestParam Map<String, Object> map) {
		ObjectMapper om=new ObjectMapper();
		ConnectionInfoVO ci=om.convertValue(map, ConnectionInfoVO.class);
		int result=cs.deleteConnectionInfo(ci);
		map.clear();
		map.put("msg", "실패");
		if(result==1) {
			map.put("msg", "성공");
		}
		log.info("requsetMap=>{}",map);
		return map;
	}
	
	@RequestMapping(value="/db_list",method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> getDatabaseList(@RequestParam Map<String, Object> map) {
		List<Map<String,Object>> dbList=cs.getDatabaseList();
		map.put("dbList", dbList);
		return map;
	}
	
	@RequestMapping(value="/tables",method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> getTableList(@RequestParam Map<String, Object> map) {
		List<ConnectionInfoVO> dbList=cs.getConnectionList();
		map.put("dbList", dbList);
		return map;
	}
	
	@RequestMapping(value="/tables/{dbName}",method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> getTableList(@PathVariable("dbName")String dbName, Map<String, Object> map) {
		List<TableVO> tableList=cs.getTableList(dbName);
		log.info("tableList =>{}",tableList);
		map.put("tableList", tableList);
		return map;
	}
	
	@RequestMapping(value="/column/{dbName}",method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> getColumnList(@PathVariable("dbName")String dbName, Map<String, Object> map) {
		List<Map<String, Object>> colList=cs.getColmnsList(dbName);
		map.put("colList", colList);
		return map;
	}
}
