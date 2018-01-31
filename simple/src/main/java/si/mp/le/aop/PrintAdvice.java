package si.mp.le.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class PrintAdvice implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {
		System.out.println("먼저됨");
		Print.ii=22;
		Object obj=mi.proceed();
		System.out.println("나중에됨");
		return obj;
	}

}
