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
import org.springframework.web.bind.annotation.ResponseBody;

import com.iot.spring.service.ConnectionInfoService;
import com.iot.spring.vo.UserInfoVO;

@Controller
@RequestMapping("/connection")
public class ConnectionInfoController {

	@Autowired
	ConnectionInfoService cis;

	private static final Logger log = LoggerFactory.getLogger(ConnectionInfoController.class);

	// 커넥션 정보들을 받아옴
	@RequestMapping("/list")
	public @ResponseBody Map<String, Object> getConnectionList(Map<String, Object> map, HttpSession hs) {
		UserInfoVO ui = new UserInfoVO();
		if (hs.getAttribute("user") != null) {
			ui = (UserInfoVO) hs.getAttribute("user");
		} else {
			ui.setuId("red");
		}
		List<Map<String, Object>> dbList = cis.getConnectionInfoList(ui);
		map.put("list", dbList);
		return map;
	}

	// 트리맵의 1레벨을 담당함 아마 1레벨일듯
	// 선택한 커넥션의 데이터베이스들을 받아오는 역할
	@RequestMapping("/db_list/{ciNo}")
	public @ResponseBody Map<String, Object> getDatabaseList(Map<String, Object> map, @PathVariable int ciNo,
			HttpSession hs) {
		try {
			List<Map<String, Object>> dbList = cis.getDatabaseList(ciNo, hs);
			map.put("list", dbList);
			map.put("parentId", ciNo);
		} catch (Exception e) {
			map.put("error", e);
			e.printStackTrace();
		}
		return map;
	}

	// 테이블들을 받아오는 역할
	@RequestMapping("/tables/{dbName}/{parentId}")
	public @ResponseBody Map<String, Object> getTableList(@PathVariable("dbName") String dbName,
			@PathVariable("parentId") String parentId, Map<String, Object> map, HttpSession hs) {
		List<Map<String, Object>> tList = cis.getTableList(hs, dbName);
		map.put("list", tList);
		map.put("parentId", parentId);
		return map;
	}

	// 테이블의 정보를 받아오는 역할(컬럼들), (select)
	@RequestMapping(value = "/columns/{dbName}/{tableName}", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getTableInfo(@PathVariable("dbName") String dbName,
			@PathVariable("tableName") String tableName, Map<String, Object> map, HttpSession hs) {
		tableName = dbName +"." + tableName;
		List<Map<String, Object>> tInfo = cis.getTableInfo(hs, tableName);
		map.put("list", tInfo);
		map.put("parentId", tableName);
		return map;
	}
	
	//테이블의 정보를 받아오는 역할(desc)
	@RequestMapping(value = "/desc/{dbName}/{tableName}", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getTableDesc(@PathVariable("dbName") String dbName,
			@PathVariable("tableName") String tableName, Map<String, Object> map, HttpSession hs) {
		tableName = dbName +"." + tableName;
		List<Map<String, Object>> tInfo = cis.descTableInfo(hs, tableName);
		map.put("list", tInfo);
		map.put("parentId", tableName);
		return map;
	}

	//커스텀 sql
	//개판이니깐 수정필수
	@RequestMapping("custom/{lastDb}/{sql}")
	public @ResponseBody Map<String, Object> runCustomSql(
			@PathVariable("lastDb") String lastDb,
			@PathVariable("sql") String sql, Map<String, Object> map,
			HttpSession hs) {
		List<Map<String, Object>> result = cis.RunCustom(hs, sql, lastDb);
		log.info("result =>{}",result);
		map.put("result", result);
		return map;
	}

}
