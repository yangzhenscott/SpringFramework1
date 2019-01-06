package com.example.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Subject{
	int buildWorld();
	void destoryJungle();
}

class RealSubject implements Subject{

	@Override
	public int buildWorld() {
		// TODO Auto-generated method stub
		System.out.println("======buildWorld=====");
		return 1;
	}

	@Override
	public void destoryJungle() {
		// TODO Auto-generated method stub
		System.out.println("========destoryJungle=======");
	}
	
}

class MyInvocationHandler implements InvocationHandler{
	
	private Object realObj;
	
	public MyInvocationHandler(Object realObj) {
		super();
		this.realObj = realObj;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("=======AOP1======");
		Object obj = method.invoke(realObj,args);
		System.out.println("=======AOP2======");
		return obj;
	}
}
/**
 * 创建代理类对象
 * @author yangZhen
 */
class MyProxy{
	public static Object bind(Object realObj){
		return Proxy.newProxyInstance(realObj.getClass().getClassLoader(), realObj.getClass().getInterfaces(), new MyInvocationHandler(realObj));
	}
}
/**
 * the core of proxy desgin pattern is lossely-coupled(松耦合)
 * @author yangZhen
 *
 */
public class TestProxy {
     public static void main(String[] args) {
    	 RealSubject realSubject = new RealSubject();
    	 Subject proxyObj = (Subject)MyProxy.bind(realSubject);
    	 proxyObj.buildWorld();
    	 proxyObj.destoryJungle();
	}
}
