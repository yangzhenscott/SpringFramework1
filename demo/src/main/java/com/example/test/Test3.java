package com.example.test;

public class Test3 extends Test1{

	private int a;
	

	
	public Test3() {
		super();
		System.out.println("======儿子初始化======");
	}



	public static void main(String[] args) {
		Test3 test3 = new Test3();
		System.out.println(test3.a);
	}
	
}
