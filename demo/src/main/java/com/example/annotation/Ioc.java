package com.example.annotation;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.component.Color;

public class Ioc {

	//对象属性在声明时，就需要调用构造函数，完成容器的初始化工作了
	 AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Annotation1.class);
	 
	 @Test
	 public void t1(){
		 printBeanName();
		 //close container
		 context.close();
	 }
	 
	 @Test
	 public void t2(){
		//close container
		 context.close();
	 }
	 
	 private void printBeanName() {
		 String[] beanNames = context.getBeanDefinitionNames();
		 for(String beanName : beanNames){
			 System.out.println(beanName);
		 }
		 Color color1 = (Color) context.getBean("yz1");
		 Color color2 = (Color) context.getBean("com.example.component.Color");
		 System.out.println(color1);
		 System.out.println(color2);
		 //工厂bean获取的是调用getObject拿到的实例化bean，而不是工厂本身的实例
		 Object factoryBeanObj1 = context.getBean("myFactory");
		 Object factoryBeanObj2 = context.getBean("myFactory");
		 Object beanFactoryObj1 = context.getBean(BeanFactory.FACTORY_BEAN_PREFIX+"myFactory");
		 System.out.println(factoryBeanObj1.getClass()+"====="+factoryBeanObj2.getClass()+"======"+(factoryBeanObj1==factoryBeanObj2));
	     System.out.println(beanFactoryObj1.getClass());
	 }
	
}
