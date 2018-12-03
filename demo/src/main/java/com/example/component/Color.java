package com.example.component;

public class Color {
	

	private int state;
	public Color(int state){
		this.state = state;
		System.out.println("Color====222222222");
	}
	
	public Color(){
		System.out.println("Color空构造函数初始化=======");
	}
	
	public void init(){
		System.out.println("Color========init=======");
	}
	
	public void destory(){
		System.out.println("Color========destory=======");

	}
	
}
