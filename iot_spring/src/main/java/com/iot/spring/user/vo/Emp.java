package com.iot.spring.user.vo;

public class Emp {

	private int empNo;
	private String empName;
	private int empSal;
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getEmpSal() {
		return empSal;
	}
	public void setEmpSal(int empSal) {
		this.empSal = empSal;
	}
	
	@Override
	public String toString() {
		return "Emp{no:"+empNo+", empName:"+empName+", empSal:"+empSal+"}";
	}
}
