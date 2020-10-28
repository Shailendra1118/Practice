package com.prac.jva;

public class AreYouVolatile {
	
	public static void main(String args[]) throws InterruptedException{
		//int count = 10;
		MyClass obj = new MyClass();
		obj.cnt = 10;
		Runnable r1 = ()->{System.out.println("cnt by thread "+obj.cnt+" "+Thread.currentThread().getName());
						obj.cnt++;
						//obj = new MyClass();
					};
		Runnable r2 = ()->{System.out.println("cnt by thread "+obj.cnt+" "+Thread.currentThread().getName());
					//obj.cnt = 100;
					if(obj.cnt == 11)
						System.out.println("found 11");
				};
		new Thread(r1).start();
		//Thread.sleep(2000);
		new Thread(r2).start();
		
	}
	
	
}

class MyClass{
	volatile int cnt = 0;
	
}
