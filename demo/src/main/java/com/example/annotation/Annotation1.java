package com.example.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.example.component.Color;
import com.example.factory.MyFactory;

//@ComponentScan(value = "com.example.*")
@Configuration
@Import({Color.class,MyImportSelector.class,MyImportBeanDefinitionRegister.class})
public class Annotation1 {
	
	/**
	 * 配置spring容器(应用上下文)
	 */
	public Annotation1(){
		System.out.println("Annotation1容器启动初始化。。。");
	}

	@Bean(value = {"yz1"})
	public Color color(){
		return new Color();
	}
	
	@Bean
	public MyFactory myFactory(){
		return new MyFactory();
	}
	
	
}
