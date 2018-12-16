package com.example.dao;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * 注册到ioc中的beanid默认是类名首字母小写形式  bookDao
 * @author yangZhen
 *
 */
@Repository
/*@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)*/
public class BookDao {
	
	private String attr = "BookDaoAttr";

	public String getAttr() {
		return attr;
	}

	public void setAttr(String attr) {
		this.attr = attr;
	}

	@Override
	public String toString() {
		return "BookDao [attr=" + attr + "]";
	}
	
	
	

}
