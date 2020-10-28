package com.prac.java.honey;

public class Test {
	
	Test(){
		System.out.println("Test constructor");
	}
	
	Test(long l){
		this();
		System.out.println(l);
	}
	
	Test(int i){
		this(89L);
		System.out.println(i*2);
	}

	public static void main(String[] args) {
		Long i = 4L;
		Test obj = new Test(i);
		obj = null;
		obj.disp("Hello"); // method is static so no null pointer exception
		
		System.out.println("T"+"E");
		System.out.println('S'+'T');

	}
	
	public static void disp(String str){
		System.out.println("dummy method");
	}

}
