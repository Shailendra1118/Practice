package com.prac.jva;

public class Honeywell implements A, B {

	public static void main(String[] args) {
		Honeywell hw = new Honeywell();
		hw.print();
		Integer a = 172;
		Integer b = 172;
		if(a == b){
			System.out.println("172, there are");
		}
		
		String c = "159"; // because of string pool concepts
		String d = "159";
		if(c == d){
			System.out.println("both strings are same.");
		}
	}
	
	@Override
	public void print() {
		System.out.println("Called..");
	}

}


interface A{
	public void print();
}

interface B{
	public void print();
}