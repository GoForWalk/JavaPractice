package com.lec.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AjaxCateList extends AjaxCateResult {

	@JsonProperty("data")
	private List<CategotyDTO> list;

	public final List<CategotyDTO> getList() {
		return list;
	}

	public final void setList(List<CategotyDTO> list) {
		this.list = list;
	}
	
	
	
}
