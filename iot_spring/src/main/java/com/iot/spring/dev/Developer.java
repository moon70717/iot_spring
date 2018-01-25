package com.iot.spring.dev;

public class Developer implements Worker{

	@Override
	public void goToWork() {
		System.out.println("개발자가 출근합니다");

	}

	@Override
	public void work() {
		System.out.println("개발자가 일을합니다");

	}

	@Override
	public void getOfWork() {
		System.out.println("개발자가 퇴근합니다");
		
	}

}
