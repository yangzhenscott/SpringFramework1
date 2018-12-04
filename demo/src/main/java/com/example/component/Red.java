package com.example.component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 对于使用beanProcesser处理器。这个结果很明显：
 * 构造函数==》postProcessBeforeInitialization===》@PostConstruct===》postProcessAfterInitialization==》destory
 * 
 * 示例如下：
 * (2)=========初始化Red实例============
	postProcessBeforeInitialization====com.example.component.Red
	(3)Red========init=======
	postProcessAfterInitialization====com.example.component.Red
 * @author yangZhen
 *
 */
public class Red {

	public Red(){
		System.out.println("(2)=========初始化Red实例============");
	}
	
	/**
	 * bean创建实例后，并且成员属性已经完成赋值操作，来回调这个注解标注的方法，post代表后的意思======》构造之后
	 */
	@PostConstruct
	public void init(){
		System.out.println("(3)Red========init=======");
	}
	
	/**
	 * pre代表前。ioc容器在销毁掉bean实例之前，通过preDestory注解标注方法通知我们进行清理工作
	 */
	@PreDestroy
	public void destory(){
		System.out.println("(4)Red========destory=======");
	}
}
