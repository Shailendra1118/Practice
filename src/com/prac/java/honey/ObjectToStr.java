package com.prac.java.honey;

public class ObjectToStr {

	public static void main(String[] args) {
		ObjectToStr obj = new ObjectToStr();
		Object a = new Object();
		Object b = new Integer(10);
		Object c = new String("str");
		obj.print(a);
		obj.print(b);
		obj.print(c);
		
		StringBuffer sb1 = new StringBuffer("M");
		StringBuffer sb2 = new StringBuffer("N");
		merge(sb1,sb2);
		System.out.println(sb1+" "+sb2);
		
		obj = null;
		obj.print(new Integer(100));
		
	}
	
	private static void merge(StringBuffer sb1, StringBuffer sb2) {
		sb1.append(sb2);
		sb2 = sb1;
	}

	public static void print(Object o){
		System.out.println("Object "+o);
	}

	public void print(String o){
		System.out.println("String "+o);
	}
	
	public void print(Integer o){
		System.out.println("Integer "+o);
	}
}

