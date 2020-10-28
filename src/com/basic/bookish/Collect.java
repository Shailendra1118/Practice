package com.basic.bookish;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Collect {

	public static void main(String[] args) {
		
		int arr[] = {2,5,1,5,12};
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
			arr[i] = 0;
		}
		
		System.out.println(Arrays.toString(arr));
		List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
		Iterator<Integer> iter = list.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
			iter.remove();
		}
		
		Set<Integer> set = new TreeSet<>();
		set.add(null);

	}

}
