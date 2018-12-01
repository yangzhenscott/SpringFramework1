package com.example.test;

import com.example.annotation.MyAnnotation;

@MyAnnotation(value = "hello")
public class Test1{
	private String a;
	
	
	
	public Test1() {
		super();
		System.out.println("======父亲被初始化======");
	}



	private Test1(String a){
		this.a= a;
	}
}
