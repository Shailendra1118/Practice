package com.prac.java.honey;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class WeirdHMap {

	public static void main(String[] args) {
		Map<KeyClass, Object> map = new HashMap<>();
		Object obj = new Object();
		map.put(new KeyClass("honeywell"), obj);
		map.put(new KeyClass("pheonix"), obj);
		map.put(new KeyClass("niagara"), obj);
		map.put(new KeyClass("novar"), obj);
		map.put(new KeyClass("alterton"), obj);
		
		Iterator<KeyClass> iter = map.keySet().iterator();
		while(iter.hasNext()){
			System.out.println(iter.next().toString());
		}
		
		Integer i = new Integer(0);
		add(null);
		System.out.println(i);
		getValue();

	}

	private static int getValue() {
		return(true ? null : 0);
	}

	private static void add(IOException i) {  // if parameter is Integer - ambiguous
		//int val = i.intValue();
		//i += 10;
		//i = i+10;
		//val = val+10;
		//i = new Integer(val);
		System.out.println("integer add");
	}
	
	private static void add(Exception e){
		System.out.println("exception");
	}
	
	private static void add(Object e){
		System.out.println("object");
	}

}

class KeyClass{
	String key;
	public KeyClass(String key){
		this.key = key;
	}
	
	public int hashCode(){
		if(key.indexOf("a") > -1)
			return 5;
		else
			return key.length();
	}
	
	public boolean equals(Object obj){
		if(key.indexOf("a") > -1)
			return true;
		else
			return false;
	}
	
	public String toString(){
		return key;
	}
}
