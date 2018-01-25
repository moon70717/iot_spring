package com.iot.spring.dev;

public class Designer implements Worker {

	@Override
	public void goToWork() {
		System.out.println("디자이너가 출근합니다");

	}

	@Override
	public void work() {
		System.out.println("디자이너가 일을합니다");

	}

	@Override
	public void getOfWork() {
		System.out.println("디자이너가 퇴근합니다");

	}

}
