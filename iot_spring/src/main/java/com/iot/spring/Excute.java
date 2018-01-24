package com.iot.spring;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Excute {

	public static void main(String[]args) {
		Resource res= new ClassPathResource("beans.xml");
		System.out.println("beans.xml 파싱완료");
		XmlBeanFactory bf=new XmlBeanFactory(res);
		HelloSpring hs=(HelloSpring)bf.getBean("hw");
		System.out.println(hs.getMessage());
		System.out.println(hs.getName());
	}
}
