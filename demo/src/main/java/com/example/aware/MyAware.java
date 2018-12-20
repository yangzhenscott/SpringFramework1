package com.example.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

/**
 * 当自定义的组件想要使用spring底层的一些组件时，需要实现一些aware接口，这些set**会通过回调方式，把你需要的spring底层的组件传入进来（通过**processer后置处理器实现的）
 *其实后置处理器也没啥神器的，原理也都是很简单，就是spring发现你实现类了**aware接口，会自动注入**processor，然后processer会用instanceof判断你是属于哪一类的aware，然后调用相应的方法，并把组件实例传参进去
  BeanPostProcessor
  （1）postProcessBeforeInitialization 
  （2postProcessAfterInitialization）
 */
@Component
public class MyAware implements ApplicationContextAware, BeanNameAware, EmbeddedValueResolverAware{

	private ApplicationContext applicationContext;
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("传入的ioc容器:"+applicationContext);
		this.applicationContext = applicationContext;
	}
	@Override
	public void setBeanName(String name) {
		// TODO Auto-generated method stub
		System.out.println("当前bean的名字:"+name);
	}
	/**
	 * 解析器,解析环境变量的值
	 */
	@Override
	public void setEmbeddedValueResolver(StringValueResolver resolver) {
		// TODO Auto-generated method stub
		String resolveStringValue = resolver.resolveStringValue("当前系统:${os.name},#{12+12}");
		System.out.println(resolveStringValue);
	}

}
