package com.iot.spring;

public class HelloSpring {

	private String msg;
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HelloSpring() {
		
	}
	
	public void setMessage(String msg) {
		System.out.println("hello");
		this.msg=msg;
	}
	
	public String getMessage() {
		return this.msg;
	}
}
