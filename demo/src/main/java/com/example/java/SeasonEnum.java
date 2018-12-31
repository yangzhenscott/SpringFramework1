package com.example.java;

public class SeasonEnum {

	public static void main(String[] args) {
		String str = MySeasonEnum.valueOf(MySeasonEnum.class, "SUMMER").getSeasonName();
		System.out.println(str);
		Broadcast obj = MySeasonEnum.SUMMER;
		obj.say();
		System.out.println(MySeasonEnum.SUMMER.getSeasonName()+":"+MySeasonEnum.SPRING.getSeasonDesc());
	}
}

/**
 * 抽象功能
 * @author yangZhen
 *
 */
interface Broadcast{
	
	void say();
	
}
/**
 * 通过enum语法糖实现枚举，同时让对象赋予say功能，通过override完成覆盖校验功能
 * @author yangZhen
 *
 */
enum MySeasonEnum implements Broadcast{
	
	SPRING("spring", "春天"){

		@Override
		public void say() {
			// TODO Auto-generated method stub
			System.out.println("1");
		}
		
	},
	SUMMER("summer", "夏天"){
		
		@Override
		public void say(){
			System.out.println("2");
		}
	};
	/*AUTUMN("autumn", "秋天"),
	WINTER("winter", "冬天");*/
	
	/**
	 * final属性，声明时初始化或者在构造函数中初始化，否则编译器报错
	 */
	private final String seasonName;
	private final String seasonDesc;
	
	private MySeasonEnum(String seasonName,String seasonDesc){
		this.seasonName = seasonName;
		this.seasonDesc = seasonDesc;
	}

	public String getSeasonName() {
		return seasonName;
	}

	public String getSeasonDesc() {
		return seasonDesc;
	}

	

	
}
