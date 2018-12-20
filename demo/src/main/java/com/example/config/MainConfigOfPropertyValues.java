package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.example.bean.Reader;

/**
 * Bean,Configuration,PropertySource,ComponentScan,import,scope
 * 这些注解出现在java config中，这些都是服务于ioc容器初始化工作的。所以package位于context.annotation
 * 在利用ComponentScan进行包扫描时：扫描包及子包下面所有包含的java文件中出线的注解：com.example.annotation   com.example.component
 * annotation中如果属性值没有写上的，说明本身有默认值，否则必须给注解的属性赋值
 * @author yangZhen
 *
 */
@PropertySource(value={"classpath:/configration.properties"})
@Configuration
@ComponentScan({"com.example.web","com.example.aware"})
public class MainConfigOfPropertyValues {

	@Bean(value="Reader2018")
	public Reader reader(){
		return new Reader();
	}
	
}
