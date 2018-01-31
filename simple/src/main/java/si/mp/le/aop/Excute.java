package si.mp.le.aop;

import org.springframework.aop.framework.ProxyFactory;

public class Excute {

	public static void main(String[]args) {
		PrintSome ps=new Print();
		ProxyFactory pf=new ProxyFactory();
		pf.addAdvice(new PrintAdvice());
		pf.setTarget(ps);
		
		Print p=(Print)pf.getProxy();
		p.hello();
	}
}
