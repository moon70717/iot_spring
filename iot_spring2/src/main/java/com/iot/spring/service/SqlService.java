package com.iot.spring.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

public interface SqlService {

	List<Map<String,Object>> RunCustom(HttpSession hs, String sql, String lastDb);
}
