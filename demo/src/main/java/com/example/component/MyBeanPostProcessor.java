package com.example.component;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * MyBeanPostProcessor会处理除了自己之外所有注入的bean，
 * 包括容器本身bean也会被过滤的（就是进入到postProcessBeforeInitialization和postProcessAfterInitialization）
 * @author yangZhen
 *
 */
/*@Component*/
public class MyBeanPostProcessor implements BeanPostProcessor{
	
	public MyBeanPostProcessor(){
		System.out.println("========初始化MyBeanPostProcessor bean实例=========");
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("postProcessBeforeInitialization===="+beanName);
        return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		 // 这边只做简单打印   原样返回bean
        System.out.println("postProcessAfterInitialization===="+beanName);
        return bean;
	}
	
	

}
