package com.example.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.dao.BookDao;
import com.example.dao.BookDaoResource;
import com.example.dao.BookDaoResource_Constructor;
import com.example.dao.BookDaoResource_Method;
import com.example.dao.BookDaoResource_Parameter;

/**
 * {@Inject}需要引入JSR330【java规范注解】
 * {@Autowired}可以标注在属性，构造，方法，参数前完成从ioc取出bean后，进行注入工作
 * @author yangZhen
 */
@Service
public class BookService {

	@Autowired(required=false)
	@Qualifier("bookDao")
	public BookDao bookDao;
	
	/**
	 * {@Resource}JSR250规范，不支持{@Primary}
	 * 默认是byname注入,默认注入的beanid为属性名
	 * 如果出现name属性，@Resource(name = "bookDaoResource")，则在ioc中寻找name属性作为beanid的bean，找不到则报错
	 * 但是不像@Autowired(required=false)一样，有required=false属性
	 * ***最好使用{@Autowired}因为这是spring原生的，尽量和其他javax解耦***
	 */
	@Resource
	public BookDaoResource bookDaoResource;
	
	public BookDaoResource_Method bookDaoResource_Method;
	
	public BookDaoResource_Constructor bookDaoResource_Constructor;
	
	
	public BookDaoResource_Method getBookDaoResource_Parameter() {
		return bookDaoResource_Method;
	}
	
	/**
	 * 创建对象时，spring会默认调用空构造器完成初始化工作
	 * {@Autowired}自己写一个有参构造器，这时传入的对象就是从ioc中取出来的bean
	 * @param bookDaoResource_Constructor
	 */
	@Autowired
	public BookService(BookDaoResource_Constructor bookDaoResource_Constructor) {
		super();
		this.bookDaoResource_Constructor = bookDaoResource_Constructor;
	}



	/**
	 * ioc容器启动后，会创建BookService这个bean对象到容器中，依赖的属性需要完成赋值初始化，这时会调用属性标记{@Autowired}对应set方法完成属性初始化工作
	 * 注入的bean是从ioc中取出来的
	 * @param bookDaoResource_Parameter
	 */
    @Autowired
	public void setBookDaoResource_Parameter(BookDaoResource_Method bookDaoResource_Method) {
		this.bookDaoResource_Method = bookDaoResource_Method;
	}

	public void print() {
        System.out.println(bookDao);
	}

	@Override
	public String toString() {
		return "BookService [bookDao=" + bookDao + ", bookDaoResource=" + bookDaoResource + ", bookDaoResource_Method="
				+ bookDaoResource_Method + ", bookDaoResource_Constructor=" + bookDaoResource_Constructor + "]";
	}

	
	
	

	
	
	
	
	
}
