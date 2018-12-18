package com.example.dao;

import org.springframework.stereotype.Repository;

@Repository
public class BookDaoResource {
	
	private String attr = "BookDaoResourceAttr";
	
	

	public String getAttr() {
		return attr;
	}

	public void setAttr(String attr) {
		this.attr = attr;
	}

	@Override
	public String toString() {
		return "BookDaoResource [attr=" + attr + "]";
	}
	
	

}

