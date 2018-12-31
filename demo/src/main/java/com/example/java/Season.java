package com.example.java;

public class Season {
	
	public static void main(String[] args) {
		System.out.println(MySeason.AUTUMN.getSeasonName());
				
	}

}

/**
 * 枚举类
 * @author yangZhen
 *
 */
class MySeason{
	private final String seasonName;
	private final String seasonDesc;
	
	private MySeason(String seasonName,String seasonDesc){
		this.seasonName = seasonName;
		this.seasonDesc = seasonDesc;
	}

	public String getSeasonName() {
		return seasonName;
	}

	public String getSeasonDesc() {
		return seasonDesc;
	}
	
	public static final MySeason SPRING = new MySeason("spring", "春天");
	public static final MySeason SUMMER = new MySeason("summer", "夏天");
	public static final MySeason AUTUMN = new MySeason("autumn", "秋天");
	public static final MySeason WINTER = new MySeason("winter", "冬天");
	
}
