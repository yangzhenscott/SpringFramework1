package com.example.config;


import java.beans.PropertyVetoException;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * {@Profile("yangzhen")}写在配置类上，{yangzhen}被激活后里面的环境配置才能生效
 * 通过profile，可以在不同的环境下加载自己需要的bean组件
 * 加了环境标识{@Profile}的bean,只有这个环境被激活后，才能DI注入进来
 * 注入bean规则:
 * (1)命令行动态参数：在虚拟机参数位置加载{-Dspring.profiles.active=test}  指定激活哪个环境 
 * (2)默认环境为default环境
 * @author yangZhen
 */
@Profile("test")
@PropertySource("classpath:/dbconfig.properties")
@Configuration
public class MainConfigOfProfile implements EmbeddedValueResolverAware{

	@Value("${db.user}")
	private String dbUser;
	
	@Value("${db.driverClass}")
	private String driverClass;
	
	private String dbUrl; 
	
	@Profile("test")
	@Bean("testDataSource")
	public DataSource dataSourceTest(@Value(value = "${db.password}")String password) throws PropertyVetoException{
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setUser(dbUser);
		dataSource.setPassword(password);
		dataSource.setJdbcUrl(dbUrl);
		dataSource.setDriverClass(driverClass);
		return dataSource;
	}
	
	@Profile("default")
	@Bean("devDataSource")
	public DataSource dataSourceDev(@Value(value = "${db.password}")String password) throws PropertyVetoException{
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setUser(dbUser);
		dataSource.setPassword(password);
		dataSource.setJdbcUrl(dbUrl);
		dataSource.setDriverClass(driverClass);
		return dataSource;
	}
	
	@Profile("realese")
	@Bean("realeseDataSource")
	public DataSource dataSourceRealese(@Value(value = "${db.password}")String password) throws PropertyVetoException{
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setUser(dbUser);
		dataSource.setPassword(password);
		dataSource.setJdbcUrl(dbUrl);
		dataSource.setDriverClass(driverClass);
		return dataSource;
	}

	@Override
	public void setEmbeddedValueResolver(StringValueResolver resolver) {
		// TODO Auto-generated method stub
		this.dbUrl = resolver.resolveStringValue("${db.url}");
	}
}
