package com.example.factory;

import org.springframework.beans.factory.FactoryBean;

import com.example.component.Color;

/**
 * 自定义bean工厂，spring framework integrate third compoent will be always useful
 * @author yangZhen
 *
 */
public class MyFactory implements FactoryBean<Color>{

	public MyFactory(){
		System.out.println("===========innitial factoryBean=========");
	}
	
	@Override
	public Color getObject() throws Exception {
		// TODO Auto-generated method stub
		return new Color(2);
	}

	@Override
	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return Color.class;
	}

	@Override
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return true;
	}

	
}
