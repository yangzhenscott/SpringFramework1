package com.example.annotation;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * 在注解中定义属性时它的类型必须是 8 种基本数据类型外加 类、接口、注解及它们的数组。
 * byte int short char float long double boolean String Arrar Enum Class
 * @author ododo
 *
 */
@Documented
@Retention(RUNTIME)
@Target(TYPE)
public @interface TestAnnotation {

	int id() default 0;
	
	String msg() default "YZ";
}
