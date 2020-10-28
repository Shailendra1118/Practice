package com.basic.bookish;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Rotate {

	public static void main(String[] args) {
		Integer arr[] = {9, 97, 94, 44, 56, 32, 100, 72, 1, 59, 33, 25, 4, 5, 40, 34, 78, 15, 73, 66, 29, 75, 32, 17, 38, 62, 67, 93, 64, 64, 71, 42, 43, 33, 11, 96, 19, 79, 32, 70, 3, 40, 49, 22, 32, 56, 38, 52, 86, 46, 25, 38, 35, 98, 1, 81, 53, 82, 36, 72, 44, 92, 16, 5, 61, 21, 93, 70, 90, 9, 42, 26, 35, 72, 40, 21, 96, 19, 82, 44, 70, 84, 85, 69, 31, 95, 63, 73, 94, 84, 14, 74, 11, 30, 47, 2}; 
			//{14, 5, 14, 34, 42, 63, 17, 25, 39, 61, 97, 55, 33, 96, 62, 32, 98, 77, 35 };
		int B = 16;
		System.out.println("size: "+arr.length);
		List<Integer> A = Arrays.asList(arr);
		List<Integer> res = rotateArray(A, B);
		System.out.println(res);
		
		
	}
	
	public static ArrayList<Integer> rotateArray(List<Integer> A, int B) {
		ArrayList<Integer> ret = new ArrayList<Integer>();
		int rotate = 0;
		if(B > A.size()){
		    rotate = B%A.size();
		    //rotate = A.size() - rotate;
		}
		else{
		    rotate = A.size()- B;
		}
		
		for (int i = rotate; i < A.size(); i++) {
			ret.add(A.get(i));
		}
		for (int i = 0; i < rotate; i++) {
			ret.add(A.get(i));
		}
		return ret;
	}
	

}
