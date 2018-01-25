package com.iot.spring.anno5;

import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component("kkk")
@Scope("prototype")
@Order(value=1)
public class Kia implements Maker{

	public void printName() {
		System.out.println("기아차");
	}

}
