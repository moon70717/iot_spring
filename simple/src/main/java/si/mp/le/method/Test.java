package si.mp.le.method;

public class Test {

	private Employer e;
	
	public void setDeveloper(Developer dev) {
		this.e=dev;
	}
	
	public void doWork() {
		System.out.println(this.e.doWork());
	}
}
