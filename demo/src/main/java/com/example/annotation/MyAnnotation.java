package com.example.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Target({ ElementType.TYPE,ElementType.METHOD})
@Retention(value = RetentionPolicy.SOURCE)
public @interface MyAnnotation {

	String value() default "hello";
}
