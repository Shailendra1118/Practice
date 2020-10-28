package com.prac.geeks;

public class IsAtomic {

	public static void main(String[] args) {
		
		A a = new A();
		
		new Thread(new Runnable() {
			public void run() {
				a.a = 1;
				a.b = 3;
			}
		}).start();
		
		new Thread(new Runnable() {
			public void run() {
				System.out.println(a.a + " " + a.b);
			}
		}).start();
		
		new Thread(new Runnable() {
			public void run() {
				a.a = 2;
				a.b = 4;
			}
		}).start();
		
		
	}

}

class A {
	public int a;
	public int b;
}
