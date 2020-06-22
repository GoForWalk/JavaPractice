package com.lec.beans;

public class AjaxCateResult {
	private int count; // 
	private String status;
	private String message;
	
	/*
	{
		count : ○○○,
		status : ○○○,
		message : ○○○
	}
	 */
	
	public AjaxCateResult() {}

	public final int getCount() {
		return count;
	}

	public final void setCount(int count) {
		this.count = count;
	}

	public final String getStatus() {
		return status;
	}

	public final void setStatus(String status) {
		this.status = status;
	}

	public final String getMessage() {
		return message;
	}

	public final void setMessage(String message) {
		this.message = message;
	}
	
	
		
	
}
