package com.iot.spring.vo;

public class UserClass {

	private int ciNo;
	private int uiNo;
	private String uiName;
	private int uiAge;
	private String uiId;
	private String uiPwd;
	private String uiRegdate;
	private String address;
	private char admin;
	
	public char admin() {
		return admin;
	}
	public void setSaveId(char admin) {
		this.admin = admin;
	}
	public int getCiNo() {
		return ciNo;
	}
	public void setCiNo(int ciNo) {
		this.ciNo = ciNo;
	}
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
	public int getUiAge() {
		return uiAge;
	}
	public void setUiAge(int uiAge) {
		this.uiAge = uiAge;
	}
	public String getUiId() {
		return uiId;
	}
	public void setUiId(String uiId) {
		this.uiId = uiId;
	}
	public String getUiPwd() {
		return uiPwd;
	}
	public void setUiPwd(String uiPwd) {
		this.uiPwd = uiPwd;
	}
	public String getUiRegdate() {
		return uiRegdate;
	}
	public void setUiRegdate(String uiRegdate) {
		this.uiRegdate = uiRegdate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "UserClass[uiNO="+uiNo+", uiName="+uiName+", uiId="+uiId+", uiRegdate="+uiRegdate+", ciNo="+ciNo+", uiAge="+uiAge+
				", uiPwd="+uiPwd+", address="+address+"]";
	}
	
	public String dhtmlJson() {
		return "{ id:"+uiNo+",data : [' "+uiNo+"', '"+uiName+"', '"+uiId+"', '"+uiRegdate+"', '"+address+"' ]}";
	}
}
