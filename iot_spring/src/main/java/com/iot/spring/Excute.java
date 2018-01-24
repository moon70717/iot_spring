package com.iot.spring;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Excute {

	public static void main(String[]args) {
		Resource res= new ClassPathResource("beans.xml");
		XmlBeanFactory bf=new XmlBeanFactory(res);
		Test t=(Test)bf.getBean("test");
		t.printTest();
	}
}