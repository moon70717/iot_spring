package com.iot.spring.anno5;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component("aaa")
@Order(value=2)
public class Audi implements Maker{
	Maker m;
	
	@Override
	public void printName() {
		System.out.println("아우디");
	}
	
}
