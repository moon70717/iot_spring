package com.iot.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.iot.spring.dev.Worker;

public class Excute {

	Worker w;
	public Excute(Worker w) {
		this.w=w;
	}
	
	public void setWorker(Worker w) {
		this.w=w;
	}
	
	public Worker getWorker() {
		return this.w;
	}
	
	
	public static void main(String[] args) {		
		ApplicationContext fac=new ClassPathXmlApplicationContext("beans.xml");
		Excute e=(Excute)fac.getBean("ex");
		Worker ww=e.getWorker();
		ww.goToWork();
	}
}