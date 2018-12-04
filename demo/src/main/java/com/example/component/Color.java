package com.example.component;

public class Color {
	

	private int state;
	public Color(int state){
		this.state = state;
		System.out.println("Color====222222222");
	}
	
	public Color(){
		System.out.println("(2)Color空构造函数初始化=======");
	}
	
	public void init(){
		System.out.println("(3)Color========init=======");
	}
	
	public void destory(){
		System.out.println("(4)Color========destory=======");

	}
	
}
