package com.iot.spring.dbcon;

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
		ssf.setConfigLocation(new ClassPathResource("/dbConnector-config.xml"));

	}
	public SqlSession getSqlSession() throws Exception {
		return ssf.getObject().openSession();
	}

	// public static void main(String[] args) throws Exception {
	// ConnectionInfoVO ci = new ConnectionInfoVO();
	// ci.setCiUrl("localhost");
	// ci.setCiPort(3306);
	// ci.setCiUser("root");
	// ci.setCiPwd("test");
	// DBConnector dbc = new DBConnector(ci);
	// Connection con = dbc.getConnection();
	// if (con != null) {
	// System.out.println("연결 성공 ");
	// }
	// }
}
