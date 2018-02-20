package com.iot.spring.DAO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public interface SqlDAO {

	List<Map<String,Object>> RunCustom(SqlSession ss, String sql, String lastDb);
}
