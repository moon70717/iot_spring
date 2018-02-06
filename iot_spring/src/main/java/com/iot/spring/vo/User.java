package com.iot.spring.vo;

public class User {
	private int uiNo;
	private String uiName;
	private String uiId;
	
	public int getUiNo() {
		return uiNo;
	}
	public void setUiNo(int uiNo) {
		this.uiNo = uiNo;
	}
	public String getUiName() {
		return uiName;
	}
	public void setUiName(String uiName) {
		this.uiName = uiName;
	}
	public String getUiId() {
		return uiId;
	}
	public void setUiId(String uiId) {
		this.uiId = uiId;
	}
	@Override
	public String toString() {
		return "UserClass[uiNo:"+uiNo+", uiName:"+uiName+", uiId:"+uiId+"]";
	}
	
	
}
