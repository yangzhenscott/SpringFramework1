package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.example.dao.BookDao;
import com.example.dao.BookDaoResource_Parameter;

/**
 * {@Autowired} 自动注入
 * spring利用依赖注入DI，完成对ioc容器中各个组件所需要的依赖进行赋值初始化，完成组件间的解耦工作
 * （1）默认根据类型装配，===>applicationContext.getBean(BookDao.class) 在ioc中找到BookDao类型的bean进行注入
 * (2)DI的时候，发现多个bean是相同类型的，===>applicationContext.getBean("bookDao2"),则把属性名作为beanid去ioc中寻找这个bean
 * (3)通过{@Qualifier}（资格者），指定我要获取的beanid
 * (4){@Qualifier}默认的required是true，则必须在ioc中找到这个bean，否则就会报错
 * @Autowired(required=false) @Qualifier("bookDao22222") 这个beanid:bookDao22222在ioc中找不到就拉倒        打印==》null
 * (5){@Primary}设置这个bean作为首选bean，在没有{@Qualifier}明确指定的时候，则注入首选bean
 * 也可以同时指定bean的名字{@Qualifier("bookDao22222")} ======》@Primary则失效
 * @author yangZhen
 */
@Configuration
@ComponentScan({"com.example.controller","com.example.dao","com.example.service","com.example.aware"})
public class MainConfigOfAutowired {
	
	/**
	 * (1){@Bean}如果没有设置默认的value属性，则把方法名作为beanid:bookDao2去isc中注册这个bean
	 * (2){@Bean("bookYang")} 指定注册beanid为bookYang
	 * ************
	 * 直接在{@Bean}标注的方法参数中加上注解，注入bean，就是默认从ioc中获取【此时@Autowired可以省略】
	 * ************
	 */
	@Bean
	@Primary
	public BookDao bookDao2(@Autowired BookDaoResource_Parameter bookDaoResource_Parameter){
		System.out.println("通过参数前加入autowired注解完成自动注入工作注bookDaoResource_Parameter:"+bookDaoResource_Parameter);
		System.out.println(bookDaoResource_Parameter.hashCode());
		BookDao bookDao = new BookDao();
		bookDao.setAttr("BookDaoAttr2");
		return bookDao;
	}
	

}
