package com.example.demo;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.config.MainConfigOfAutowired;
import com.example.dao.BookDao;
import com.example.dao.BookDaoResource_Parameter;
import com.example.service.BookService;

/**
 * 原理：通过{AutowiredAnnotationBeanPostProcessor}，解析DI自动注入的注解
 * 之前好像有个工厂bean是干嘛的来着？？？
 * @author yangZhen
 *
 */
public class TestAnnotationOfAutowired {

	public AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);
	
	@Test
	public void testAutoWired(){
		BookService bookService = context.getBean(BookService.class);
		System.out.println("当前bookService:"+bookService);
		bookService.print();
		BookDao bookDao = (BookDao) context.getBean("bookDao");
		System.out.println(bookDao);
		//打印这个类型的所有beanid
		String[] beanNames = context.getBeanNamesForType(BookDao.class);
		for(String beanName : beanNames){
			System.out.println(beanName);
		}
	}
}
