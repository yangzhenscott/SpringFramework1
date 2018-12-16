package com.example.demo;

import org.apache.catalina.core.ApplicationContext;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import com.example.bean.Reader;
import com.example.config.MainConfigOfPropertyValues;

public class TestMainConfigOfMainProperty {

	public AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfigOfPropertyValues.class);
	public ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/beans.xml");
	public void test(){
		printBean();
		Reader Reader2018 = (Reader) annotationConfigApplicationContext.getBean("Reader2018");
		System.out.println(Reader2018);
		ConfigurableEnvironment environment = annotationConfigApplicationContext.getEnvironment();
		System.out.println(environment.getProperty("honeyLover"));
	}
	
	@Test
	public void t1(){
		Reader Reader2018 = (Reader) applicationContext.getBean("instanceName");
		System.out.println(Reader2018);
	}
	
	private void printBean() {
		String[] benaNames = annotationConfigApplicationContext.getBeanDefinitionNames();
		for(String benaName : benaNames){
			System.out.println(benaName);
		}

	}
}
