package com.example.annotation;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import com.example.component.Rainbow;

public class MyImportBeanDefinitionRegister implements ImportBeanDefinitionRegistrar{

	/**
	 * 自定义，通过import注解注入哪些组件至容器中
	 * @param importingClassMetadata 配置类下的所有注解元数据
	 * @param BeanDefinitionRegistry BeanDefinition注册类
	 */
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		// TODO Auto-generated method stub
		Boolean boolean1 = registry.containsBeanDefinition("com.example.component.Color");
		if(boolean1){
			RootBeanDefinition definition = new RootBeanDefinition(Rainbow.class);
			registry.registerBeanDefinition("rainbow", definition);
		}
	}

}
