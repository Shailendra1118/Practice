package com.basic.bookish;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Hacker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// long i = 330L;
		// System.out.println(i);
		// long res = (long) Math.pow(2, 3);
		// System.out.println(res);
		long ctn = 0l;
		for (int i = 0; i < 10; i++) {
			double[] calories = new double[10];
			ctn = ctn + (long) (Math.pow(2, i) * calories[i]);
		}

		int arr[] = { 12, 3, 6, 45, 9, 23, 56, 77 };
		Comparator<Integer> comp = (a, b) -> {
			if (a < b)
				return +1;
			else if (a > b)
				return -1;
			else
				return 0;
		};

		List<Integer> list = IntStream.of(arr).boxed()
				.sorted(Collections.reverseOrder())
				.collect(Collectors.toList());

		System.out.println(list);

		// // your code goes here
		// Arrays.sort(calories);
		// long ctn = 0L;
		// for(int i=0; i<n; i++){
		// ctn = ctn + (long)(Math.pow(2,i) * calories[i]);
		// }
		// System.out.println(ctn);

		float[] unsorted = new float[100];
		long count = Stream.of(unsorted).count();
		System.out.println("count " + count);

		// List<Double> list1 = IntStream.range(0,
		// unsorted.length).mapTo(i->unsorted[i]).boxed().sorted(Collections.reverseOrder()).collect(Collectors.to);
		// System.out.println(list1);
	}

}
