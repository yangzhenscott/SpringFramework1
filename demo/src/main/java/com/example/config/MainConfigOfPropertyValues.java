package com.example.config;

import java.util.ArrayList;
import java.util.List;

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

	private Character str;
	
	private char number;
	
	
	

	public Character getStr() {
		return str;
	}

	public void setStr(Character str) {
		this.str = str;
	}

	public char getNumber() {
		return number;
	}

	public void setNumber(char number) {
		this.number = number;
	}

	@Bean(value="Reader2018")
	public Reader reader(){
		return new Reader();
	}
	
	public static void main(String[] args) {
		Integer a=127;
		Integer a1=127;
		Integer a2=new Integer(127);
		System.out.println(a==a1);
		System.out.println(a2==a1);
		
		Integer b=128;
		Integer b1=128;
		Integer b2=new Integer(128);
		System.out.println(b==b1);
		System.out.println(b2==b1);
		
		MainConfigOfPropertyValues obj=new MainConfigOfPropertyValues();
		System.out.println(obj.str);
		System.out.println(obj.number);
		String[] arr=new String[]{"ss"};
		//System.out.println(arr[1]);
		int[] arr1 = new int[2];
		int[] arr3 = {};
		
		List<String> list=new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		for(String str : list){
			if("3".equals(str)){
				list.remove(str);
			}
		}
		System.out.println(list.toString());
		
		
	}
	
}
