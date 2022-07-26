package com.lti.entity;

import org.springframework.stereotype.Component;

@Component
public class Tyre {
	String make;
	String size;
	String type;
	
	
	
	
	public Tyre() {
		super();
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public void showTyreDetails() {
		System.out.println("Make: " + this.getMake() + " Size: " + this.getSize() + " Type: " + this.getType());
	}
}
