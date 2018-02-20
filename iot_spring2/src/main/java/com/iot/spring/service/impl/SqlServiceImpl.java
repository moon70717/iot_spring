package com.iot.spring.service.impl;

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
	public List<Map<String, Object>> RunCustom(HttpSession hs, String sql, String lastDb) {
		List<List<Map<String, Object>>> list;
		SqlSession ss = (SqlSession) hs.getAttribute("SqlSession");
		String[] sqls=sql.split(";");
		return sDAO.RunCustom(ss, sqls, lastDb); 
	}

}
