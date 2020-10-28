package com.prac.java.honey;

import java.util.HashMap;

public class Trying {

	public static void main(String[] args) {
		String ip = "7 U 0 T7165 0128862 089 39 5";
		int res = atoi(ip.trim());
		//int res1 = atoi("111");
		//double i = Math.pow(100, 0);
		
		System.out.println(res);
	}
	
	public static int atoi(final String a) {
	    HashMap<Character,Integer> map = new HashMap<>();
	    map.put('9',9);
	    map.put('8',8);
	    map.put('7',7);
	    map.put('6',6);
	    map.put('5',5);
	    map.put('4',4);
	    map.put('3',3);
	    map.put('2',2);
	    map.put('1',1);
	    map.put('0',0);
	    
	    int len = a.length()-1;	    
	    int res = 0;
	    for(int i=0; i< a.length(); i++){
	        char cur = a.charAt(i);
	        System.out.println("cur: "+cur);
	        if(cur == ' ' || !(cur > 47 && cur < 58)){
	        	break;
	        }
	        int digit = map.get(cur);
	        System.out.println("Digit "+cur+" "+digit);
	        if(len > 0)
	        	res = (int) (res + (digit * Math.pow(10, len)));
	        else
	        	res = (int) (res + digit);
	        System.out.println("Res: "+res);
	        len--;
	    }
	    
	    return res;
	}

}
