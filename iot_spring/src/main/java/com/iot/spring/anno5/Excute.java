package com.iot.spring.anno5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Excute {
	
	

	public static void main(String[]args) {
		ApplicationContext ac=new ClassPathXmlApplicationContext("anno5/ioc.xml");
		Order m=(Order)ac.getBean("order");
		m.printMaker();
		m.printMList();
		
	}
	
	
}
