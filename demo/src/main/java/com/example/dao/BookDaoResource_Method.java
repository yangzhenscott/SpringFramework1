package com.example.dao;

import org.springframework.stereotype.Component;

@Component
public class BookDaoResource_Method {

	private String attr = "BookDaoResource_MethodAttr";

	public String getAttr() {
		return attr;
	}

	public void setAttr(String attr) {
		this.attr = attr;
	}

	@Override
	public String toString() {
		return "BookDaoResource_Method [attr=" + attr + "]";
	}
	
	
}
