package ex3_1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


public class PlusOp implements OperatorBean {

	@Autowired
	@Qualifier("operand1")
	Operand operand1;
	
	@Autowired
	@Qualifier("operand2")
	Operand operand2;

	@Override
	public int doOperate() {
		return operand1.getValue() + operand2.getValue();
	}

}
