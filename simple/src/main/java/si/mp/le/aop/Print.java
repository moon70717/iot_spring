package si.mp.le.aop;

public class Print implements PrintSome {

	static int ii=3;
	
	@Override
	public void hello() {
		System.out.println("hello mthod from print class"+ii);
	}

}
