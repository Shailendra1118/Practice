package com.basic.bookish;


public class PalinSubStr {
	static String s = "abcb";
	public static void main(String[] args) {
		String s = "abcb";
		int count = countSubSeq(0, s.length()-1);
		System.out.println("palindrome in "+s+": "+count);
	}

	private static int countSubSeq(int i, int j) {
		System.out.println("i:"+i+" j:"+j);
		//if(i >= s.length() || j < 0)
		//	return 0;
		//base case
		if(i == j)
			return 1;
//		if(i < 0 || j < 0)
//			return 0;
//		
		if(j == i+1){
			if(s.charAt(i) == s.charAt(j))
				return 1;
		}
		else if(s.charAt(i) == s.charAt(j)){
			return countSubSeq(i+1, j) + countSubSeq(i, j-1) + 1;
		}
		return countSubSeq(i+1, j) + countSubSeq(i, j-1)
					-countSubSeq(i+1, j-1);
	}

	private static boolean isPalm(String s) {
		int i = 0;
		int j = s.length()-1;
		boolean flag = true;
		while(i<j){
			if(s.charAt(i) == s.charAt(j)){
				i++;
				j--;
			}else{
				flag =false;
				break;
			}
		}
		return flag;
	}

}
