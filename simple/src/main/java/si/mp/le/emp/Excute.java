package si.mp.le.emp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Excute {
	
	public static void main(String[]args) {
		ApplicationContext ac=new ClassPathXmlApplicationContext("emp/ioc.xml");
		EmpDAO eDAO=(EmpDAO) ac.getBean("edao");
		EmpService eService=(EmpService)ac.getBean("eser");
		
		System.out.println(eService.selectEmpList());
		
		Emp e=new Emp();
		e.setEmpNo(2);
		System.out.println(eService.selectEmp(e));
		
		e=new Emp();
		e.setEmpName("test");
		e.setEmpSal(33);
		System.out.println(eService.insertEmp(e));
		
		e=new Emp();
		e.setEmpName("바꿈");
		e.setEmpSal(44);
		e.setEmpNo(5);
		System.out.println(eService.updateEmp(e));
		
		e=new Emp();
		e.setEmpNo(6);
		System.out.println(eService.deleteEmp(e));
	}
}
