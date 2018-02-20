package com.iot.spring.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iot.spring.DAO.SqlDAO;
import com.iot.spring.service.SqlService;

@Service
public class SqlServiceImpl implements SqlService {

	@Autowired
	SqlDAO sDAO;
	
	@Override
	public List<List<Map<String, Object>>> RunCustom(HttpSession hs, String sql, String lastDb) {
		List<List<Map<String, Object>>> list = new ArrayList<List<Map<String, Object>>>();
		SqlSession ss = (SqlSession) hs.getAttribute("SqlSession");
		//sql="select * from user_info";
		String[] sqls=sql.split(";");
		for(String s:sqls) {
			list.add(sDAO.RunCustom(ss, s, lastDb));
		}
		return list; 
	}

}
