package ex2_1;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DIApp {

	public static void main(String[] args) {
		
		AbstractApplicationContext ctx
			= new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		OperatorBean operatorBean = null;
		
		operatorBean = (OperatorBean)ctx.getBean("op");
		
		int value = operatorBean.doOperate();
		
		System.out.println(value);
	}

}
