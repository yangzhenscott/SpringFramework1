package com.example.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import com.example.component.Color;
import com.example.component.MyBeanPostProcessor;
import com.example.factory.MyFactory;

/*为啥这样扫描不到MyBeanPostProcessor类呢？？？？    @ComponentScan(value = "com.example.component.*")*/
/*@ComponentScan(value = "com.example.component")*/
@Configuration
@Import({MyImportSelector.class,MyImportBeanDefinitionRegister.class})
public class Annotation1 {
	
	/**
	 * 配置spring容器(应用上下文)
	 */
	public Annotation1(){
		System.out.println("Annotation1容器启动初始化。。。");
	}

	/**
	 * if scope is singleton by default，as the spring container initialization done,then bean created
	 * if scope is prototype,only when use it ,then container assist to injury to variable declare,
	 * every times is diff bean instance
	 * bean的生命周期：创建-----初始化-------销毁
	 * 单例bean，容器启动并创建完成，执行bean的：创建-----初始化
	 * 原型bean,容器启动并创建完成和bean无关，只有注入bean时，执行bean的：创建-----初始化
	 * bean在注册的时候，需要调用构造方法，因为注册的肯定是一个实例，如果只是声明一个null对象引用没有任何意义
	 * 所以，import是在注册bean，肯定也就需要实例化了
	 * 原型是现注册，现注入======现买菜现做饭，而不是把菜提前买好（创建），并切好了（初始化）
	 * 正常情况下，spring ioc容器负责bean的整个生命周期，同时亦可以自定义不同生命周期的方法，在生命周期的不同阶段，由ioc负责调用，容器销毁了，同样也就会call bean的destory
	 * 但是如果为prototype，ioc才不会管一个prototype bean的死活了，因为太多了，不可能跟踪每一个新创建的bean是在何时被销毁的
	 * 
	 */
	//@Scope("prototype")
	@Bean(value = {"yz1"},initMethod = "init",destroyMethod="destory")
	public Color color(){
		System.out.println("=====(1)color====");
		return new Color();
	}
	
	/**
	 * 定义工厂bean
	 * 思考下：如果想要工厂生产出一件东西，肯定要有一个工厂，所以工厂bean需要最先被创建出来
	 * 根据工厂bean在容器中注册的id，获得的肯定是工厂生产的bean，而不是拿到工厂bean本身
	 * @return
	 */
	@Bean
	public MyFactory myFactory(){
		return new MyFactory();
	}
	
	/**
	 * 今天学到bean的生命周期了，开始一轮小的sprint周期了
	 */
	
	/**
	 * 一定要提高英语能力，将注释信息翻译成人话
	 * 学会正确的解读javadoc
	 * 学会看debug的调用栈
	 */
	
	
	/**
	 * 我他妈想说spring context event那些bean为啥不进处理器
	 * {@link} http://blog.51cto.com/4247649/2118350
	 * @return
	 */
	@Bean
	public MyBeanPostProcessor myBeanPostProcessor(){
		return new MyBeanPostProcessor();
	}
	
}
