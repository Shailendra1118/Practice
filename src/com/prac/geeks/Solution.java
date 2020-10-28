package com.prac.geeks;

import java.util.EmptyStackException;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		String S = " 30 + 20 - - "; //"1048576 1048576 + DUP 4 POP 5 DUP + DUP + -";
		int res = solution(S);
		System.out.println("Result: "+res);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Math.pow(2, 20));
	}

	private static int solution(String str) {
		String arr[] = str.split(" ");
		int i = 0;
		boolean error = false;
		double max = Math.pow(2, 20)-1;
		Stack<Integer> stack = new Stack<Integer>();
		while(i < arr.length){
			String op = arr[i].trim();
			if(isNumeric(op)){
				int val = Integer.valueOf(op);
				if(val > max){
					error = true;
					break;
				}					
				//push into stack
				stack.push(Integer.valueOf(op));
			}
			else if("DUP".equals(op)){
				if(stack.isEmpty()){
					error = true;
					break;
				}				
				stack.push(stack.peek());
			}
			else if("POP".equals(op)){
				stack.pop();
			}
			else if("-".equals(op)){
				int a = 0;
				int b = 0;
				try{
					a = stack.pop();
					b = stack.pop();
				}catch(EmptyStackException e){
					error = true;
					break;
				}		
				if(checkUnderOverFlow(a, b, max, op))
					stack.push(a-b);
				else {
					error = true;
					break;
				}
			}
			else if("+".equals(op)){			
				int a = 0;
				int b = 0;
				try{
					a = stack.pop();
					b = stack.pop();
				}catch(EmptyStackException e){
					error = true;
					break;
				}		
				if(checkUnderOverFlow(a, b, max, op))
					stack.push(a+b);
				else {
					error = true;
					break;
				}
			}		
			//increment the counter
			i++;
		}
		if(error)
			return -1;
		else{
			if(stack.isEmpty())
				return -1;
			else
				return stack.pop();
		}
	
	}	


	public static boolean isNumeric(String s) {  
	    return s.matches("\\d*\\.?\\d+");  
	}  
	
	public static boolean checkUnderOverFlow(int a, int b, double max, String op) {
		if("-".equals(op)){
			if(a-b < 0)
				return false;
			if(Math.abs(a-b) > max)
				return false;
			else
				return true;
		}
		
		if("+".equals(op)){
			if(Math.abs(a+b) > max)
				return false;
			else
				return true;
		}
		return false;
	} 

}
