package com.example.demo;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.config.MainConfigOfProfile;

/**
 * 设置环境变量值
 * （1）直接在虚拟机中设置参数，这种方式较为灵活，而且这些设置environment中包含参数的过程一定是在初始化ioc容器之前完成的
 * （2）通过代码方式设置environment包含哪些参数
 * @author yangZhen
 *
 */
public class IOCTest_Profile {
	/**
	 *通过注解有参构造器启动方式:要激活的环境还没来得及设置呢！！！
	 *this();  //初始化容器bean的实例
	 *register(annotatedClasses);  //注册java配置类
	 *refresh();   //启动刷新ioc容器
	 */
	private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfProfile.class);
	
	@Test
	public void test(){
		String[] beanNames = context.getBeanNamesForType(DataSource.class);
		for(String beanName : beanNames){
			System.out.println(beanName);
		}
	}
	
	/**
	 * (3)通过代码激活环境
	 */
	@Test
	public void test1(){
		//1.初始化容器bean
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		//设置需要激活的环境变量
		context.getEnvironment().setActiveProfiles("test","realese");
		//注册配置类
		context.register(MainConfigOfProfile.class);
		//ioc容器启动刷新
		context.refresh();
		String[] beanNames = context.getBeanNamesForType(DataSource.class);
		for(String beanName : beanNames){
			System.out.println(beanName);
		}
	}
	
	
}
