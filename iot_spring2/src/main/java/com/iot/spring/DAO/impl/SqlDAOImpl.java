package com.iot.spring.DAO.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.iot.spring.DAO.SqlDAO;

@Repository
public class SqlDAOImpl implements SqlDAO {

	@Override
	public List<Map<String, Object>> RunCustom(SqlSession ss, String[] sql, String lastDb) {
		ss.selectList("connection.selectDb", lastDb);
		return ss.selectList("connection.runSql", sql);
	}
}
