package com.prac.test;

import java.io.FileNotFoundException;

import com.prac.main.YourClass;

public class MyClass extends YourClass {
	public void disp() throws FileNotFoundException{
		this.setCount(110);
		System.out.println("in disp of MyClass");
	}
}
