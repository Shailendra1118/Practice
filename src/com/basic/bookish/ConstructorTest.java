package com.basic.bookish;

public class ConstructorTest {

	public static void main(String[] args) {
		
		Parent p = new Parent("parent args");
		System.out.println(p.hashCode());
	}
	
	
	static class Parent{
		public Parent(String arg){
			System.out.println("arg in parent");
		}
		
//		public Parent(){
//			System.out.println("default parent con");
//		}
	}
	
	static class Child extends Parent{
		public Child(String arg){
			super(arg); // call to parent custom constructor is mandatory, 
			// if default constructor were there JVM implicit calls place call
			// of default parent constructor here
			System.out.println("arg in parent");
		}
		
		public Child(){			
			super("test");
			final int value = 0;
			System.out.println("con with no arg");
		}
	}

}


