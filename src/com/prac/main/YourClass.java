package com.prac.main;

import java.io.FileNotFoundException;

public class YourClass {
	private int count = 1;
	
	protected void disp() throws FileNotFoundException{
		System.out.println("disp method in yourClass");
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
