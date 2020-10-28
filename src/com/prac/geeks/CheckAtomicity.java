package com.prac.geeks;

public class CheckAtomicity {
	int a;
	int b;

	public static void main(String[] args) {
		CheckAtomicity obj1 = new CheckAtomicity();
		// A a = new A();
		new Thread(new Runnable() {
			public void run() {
				obj1.a = 2;
				obj1.b = 4;
			}
		}).start();
		
		new Thread(new Runnable() {
			public void run() {
				obj1.a = 1;
				obj1.b = 3;
			}
		}).start();
		
		new Thread(new Runnable() {
			public void run() {
				System.out.println(obj1.a + " " + obj1.b);
			}
		}).start();

		

	}

}
