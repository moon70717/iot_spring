package com.iot.spring.anno5;

import java.util.List;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@Named
public class Order {
	@Autowired
	@Qualifier("aaa")
	private Maker m;
	@Autowired
	private List<Maker>mList;
	
	public void printMaker() {
		m.printName();
	}
	
	public void printMList() {
		for(Maker m:mList) {
			m.printName();
		}
	}
}
