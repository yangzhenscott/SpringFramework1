package com.example.test;

import com.example.annotation.MyAnnotation;

@MyAnnotation(value = "hello")
public class Test {
	
	private final String con;
	

	private Test(String con) {
		super();
		this.con = con;
	}


	@MyAnnotation(value = "hello")
	@Deprecated
	public void say(){}

	
	
	public void say1(){
		say();
	}
}
