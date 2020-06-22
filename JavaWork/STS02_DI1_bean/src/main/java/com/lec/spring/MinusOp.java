package com.lec.spring;

import ex2_1.OperatorBean;

public class MinusOp implements OperatorBean {

	int operand1;
	int operand2;
	

	@Override
	public int doOperate() {
		return operand1 - operand2;
	}

	

}
