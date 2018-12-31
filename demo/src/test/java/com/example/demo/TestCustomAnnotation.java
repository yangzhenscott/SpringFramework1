package com.example.demo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.example.annotation.Check;
import com.example.annotation.Perform;
import com.example.annotation.TestAnnotation;

/**
 * 读取注解属性值，通过反射获取注解class
 * 学习如何进行注解提取
 * @author ododo
 *
 */
@TestAnnotation
public class TestCustomAnnotation {
	@Check("60inch")
	int hip;
	
	@Perform
	public void testMethod() {}

	public static void main(String[] args) {
		Boolean isExistAnnotation = TestCustomAnnotation.class.isAnnotationPresent(TestAnnotation.class);
		if(isExistAnnotation) {
			TestAnnotation annotation = TestCustomAnnotation.class.getAnnotation(TestAnnotation.class);
			System.out.println(annotation.id());
			System.out.println(annotation.msg());
		}
		try {
			Field field = TestCustomAnnotation.class.getDeclaredField("hip");
			field.setAccessible(true);
			Check checkObj = field.getAnnotation(Check.class);
			if(checkObj != null) {
				System.out.println("Check注解的value属性值："+checkObj.value());;
			}
			Method method = TestCustomAnnotation.class.getDeclaredMethod("testMethod");
			if(method != null) {
				Annotation[] annotationsArr = method.getAnnotations();
				for(Annotation ann : annotationsArr) {
					System.out.println(ann.annotationType().getName());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
