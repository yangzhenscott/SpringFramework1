package com.example.web;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.properties.InBean;

/**
 * 默认注入有个组件id为类名首字母小写到ioc容器中
 * @author yangZhen
 *
 */
@RestController
public class HelloController {

	/*@Value("${hello}")
	private String hello;
	
	@Resource
	private InBean inBean;
	
	@RequestMapping("hello")
	public String hello() {
		return inBean.getUserName()+"<br/>"
				+inBean.getDburl()+"<br/>"
						+inBean.getDriver()+"<br/>"
								+inBean.getPass()+"<br/>";
	}*/
}
