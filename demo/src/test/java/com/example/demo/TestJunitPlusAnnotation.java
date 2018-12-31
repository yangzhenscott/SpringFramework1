package com.example.demo;

import java.lang.reflect.Method;

import com.example.annotation.JunitPLus;

public class TestJunitPlusAnnotation {

	@JunitPLus
	void plus() {
		System.out.println("1+1="+(1+1));
	}
	@JunitPLus
	void minus() {
		System.out.println("1-1="+(1-1));
	}
	@JunitPLus
	void multiply() {
		System.out.println("1*1="+(1*1));
	}
	@JunitPLus
	void divide() {
		System.out.println("1/0="+(1/0));
	}
	
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		TestJunitPlusAnnotation junitPlusAnnotation = new TestJunitPlusAnnotation();
		//通过反射获取到所有的method对象
		Method[] fields = junitPlusAnnotation.getClass().getDeclaredMethods();
		//判断method对象是否包含{@JunitPLus}注解
		for(Method m : fields) {
			//如果包含，通过反射调用，catch中捕获错误日志
			if(m.isAnnotationPresent(JunitPLus.class)) {
				m.setAccessible(true);
				try {
					m.invoke(junitPlusAnnotation);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					sb.append(m.getName()+"\n\r");
					sb.append(e.getCause().getMessage()+"\n\r");
					sb.append(e.getCause().getClass().getName());
				}
			}
		}
		System.out.println(sb.toString());
	}
}


