package com.iot.spring.utils.dbcon;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.core.io.ClassPathResource;

import com.iot.spring.vo.ConnectionInfoVO;

public class DBConnector {

	private BasicDataSource bds;
	private SqlSessionFactoryBean ssf;
	private SqlSession ss;

	public DBConnector(ConnectionInfoVO ci) throws Exception {
		bds = new BasicDataSource();
		bds.setDriverClassName("org.mariadb.jdbc.Driver");
		String url = "jdbc:mysql://" + ci.getCiUrl() + ":" + ci.getCiPort();
		bds.setUrl(url);
		bds.setUsername(ci.getCiUser());
		bds.setPassword(ci.getCiPwd());
		ssf = new SqlSessionFactoryBean();
		ssf.setDataSource(bds);
		ssf.setConfigLocation(new ClassPathResource("/mybatis-config.xml"));

	}
	public SqlSession getSqlSession() throws Exception {
		return ssf.getObject().openSession();
	}
}
