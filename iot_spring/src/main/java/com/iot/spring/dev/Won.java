package com.iot.spring.dev;

import org.springframework.stereotype.Component;

@Component("hi")
public class Won {
	
	private int money;
	
	public Won() {
		System.out.println("won 생성");
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

}
