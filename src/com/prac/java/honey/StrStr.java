package com.prac.java.honey;

public class StrStr {

	public static void main(String[] args) {
		int res = strStr("bbbbbbbbab","baba");
		System.out.println("res: "+res);
	}
	
	public static int strStr(final String haystack, final String needle) {
	    if(haystack == null || haystack.length() == 0)
	    return -1;
	    
	    if(needle == null || needle.length() == 0)
	    return -1;
	    
	    int start = -1;
	   // int idx = -1;
	    //int nl = needle.length();
	    for(int i=0; i< needle.length(); i++){
	        for(int j=i; j< haystack.length(); j++){
	            if(haystack.charAt(i) == needle.charAt(i)){
	                if(start == -1){
	                    start = i;
	                }
	                break;
	            }else{
	                start = -1;
	                i = 0;
	            }
	    }
	    
	}
	return start;
	}

}
