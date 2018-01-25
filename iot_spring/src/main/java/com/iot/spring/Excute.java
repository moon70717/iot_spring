package com.iot.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.iot.spring.anno5.Maker;

public class Excute {
	
	public static void main(String[] args) {		
		ApplicationContext ac=new ClassPathXmlApplicationContext("anno5/ioc.xml");
		Maker m=(Maker)ac.getBean("kia");
		System.out.println(m);
		m=(Maker)ac.getBean("kia");
		System.out.println(m);
		m=(Maker)ac.getBean("kia");
		System.out.println(m);
		m=(Maker)ac.getBean("kia");
		System.out.println(m);
		m.printName();
	}
}