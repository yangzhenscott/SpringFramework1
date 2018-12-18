package com.example.dao;

import org.springframework.stereotype.Component;

@Component
public class BookDaoResource_Constructor {

	private String attr = "BookDaoResource_ConstructorAttr";

	public String getAttr() {
		return attr;
	}

	public void setAttr(String attr) {
		this.attr = attr;
	}

	@Override
	public String toString() {
		return "BookDaoResource_Constructor [attr=" + attr + "]";
	}
}
