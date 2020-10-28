package com.prac.idererve;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class IsPermutePalindrom {

	public static void main(String[] args) {
		String str = "abbbaa";
		Map<Integer, Long> map = str.chars().boxed().collect(Collectors.groupingBy(
				Function.identity(), Collectors.counting()));
		long count = map.values().stream().filter(p -> p%2 == 1).count();
		System.out.println("count is "+count);
		if(count <= 1)
			System.out.println("can become palindrom");
		else
			System.out.println("Nope.");
		
		
	}

}
