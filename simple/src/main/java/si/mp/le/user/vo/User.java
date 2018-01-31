package si.mp.le.user.vo;

import org.springframework.stereotype.Component;

@Component
public class User {

	private String uiName;
	private int uiAge;
	
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
	
	
}
