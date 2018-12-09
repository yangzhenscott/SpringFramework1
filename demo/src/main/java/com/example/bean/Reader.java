package com.example.bean;

import org.springframework.beans.factory.annotation.Value;

public class Reader {
	@Value("honeyName")
	private String name;

	@Value("80")
	private String hip;
	
	
	public String getHip() {
		return hip;
	}

	public void setHip(String hip) {
		this.hip = hip;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Reader [name=" + name + ", hip=" + hip + "]";
	}

	
	
	

}
