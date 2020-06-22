package com.lec.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CategotyDTO {
	
	@JsonProperty("ca_uid")
	private int uid; // ca_uid
	
	@JsonProperty("ca_name")
	private String name; // ca_name
	
	@JsonProperty("ca_depth")
	private int depth; // ca_depth
	
	@JsonProperty("ca_parent")
	private int parent; // ca_parent
	
	@JsonProperty("ca_order")
	private int order; // ca_order
	
	
	public CategotyDTO() {
		
		super();
	}

	public CategotyDTO(int uid, String name, int depth, int parent, int order) {
		super();
		this.uid = uid;
		this.name = name;
		this.depth = depth;
		this.parent = parent;
		this.order = order;
	}


	public final int getUid() {
		return uid;
	}


	public final void setUid(int uid) {
		this.uid = uid;
	}


	public final String getName() {
		return name;
	}


	public final void setName(String name) {
		this.name = name;
	}


	public final int getDepth() {
		return depth;
	}


	public final void setDepth(int depth) {
		this.depth = depth;
	}


	public final int getParent() {
		return parent;
	}

	public final void setParent(int parent) {
		this.parent = parent;
	}

	public final int getOrder() {
		return order;
	}

	public final void setOrder(int order) {
		this.order = order;
	}
	
	
}
