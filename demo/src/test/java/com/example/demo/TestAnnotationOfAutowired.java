package com.example.demo;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.config.MainConfigOfAutowired;
import com.example.dao.BookDao;
import com.example.service.BookService;

public class TestAnnotationOfAutowired {

	public AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);
	
	@Test
	public void testAutoWired(){
		BookService bookService = context.getBean(BookService.class);
		bookService.print();
		BookDao bookDao = (BookDao) context.getBean("bookDao");
		System.out.println(bookDao);
	}
}
