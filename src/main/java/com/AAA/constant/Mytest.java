package com.AAA.constant;

public class Mytest {
	public static void main(String[] args) {
		ProductCategory category=ProductCategory.FOOD;
		String s=category.name(); //將enum值轉字串
		System.out.println(s); //FOOD
		
		String s2 ="CAR";
		ProductCategory category2=ProductCategory.valueOf(s2);
	}
}
