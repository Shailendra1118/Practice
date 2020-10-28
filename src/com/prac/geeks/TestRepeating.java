package com.prac.geeks;

public class TestRepeating {

	public static void main(String[] args) {
		int i = 1;
		int tillNow = 0;
		for (i = 1; i <= 5; i++) {
			System.out.println("XOR "+(tillNow ^ i));
			tillNow = tillNow ^ i;			
			if(i == 2 || i == 4){
				tillNow = tillNow ^ i;
			}
		}
		
		String arr[] = new String[10];
		System.out.println(arr);
		
	}

}
