package com.example.demo;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import com.example.bean.Reader;
import com.example.config.MainConfigOfPropertyValues;

public class TestMainConfigOfMainProperty {

	public AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfigOfPropertyValues.class);

	@Test
	public void test(){
		printBean();
		Reader Reader2018 = (Reader) annotationConfigApplicationContext.getBean("Reader2018");
		System.out.println(Reader2018);
		ConfigurableEnvironment environment = annotationConfigApplicationContext.getEnvironment();
		System.out.println(environment.getProperty("honeyLover"));
	}
	
	private void printBean() {
		String[] benaNames = annotationConfigApplicationContext.getBeanDefinitionNames();
		for(String benaName : benaNames){
			System.out.println(benaName);
		}

	}
}
