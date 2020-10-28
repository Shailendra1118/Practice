package com.prac.idererve;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class GroupThem {

	public static void main(String[] args) {
		String[] arr = {"abcd", "abc", "abce", "acd","abdc"};
		System.out.println(Arrays.toString(arr));
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		Collections.sort(Arrays.asList(arr), new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				char co1[] = o1.toCharArray(); Arrays.sort(co1);
				System.out.println("co1 post sort: "+Arrays.toString(co1));
				char co2[] = o2.toCharArray(); Arrays.sort(co2);
				System.out.println("co2 post sort: "+Arrays.toString(co1));
				if(co1.equals(co2))
					return 0;
				else 
					return -1;
				
				//return new String(co1).compareTo(new String(co2));
			}
		});
		System.out.println(Arrays.toString(arr));
	}

}

