/**
 * 
 */
package com.basic.bookish;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Shailendra
 *
 */
public class MaxSliceCodility {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int arr[] = { 12, 0, 5, 4, 4, 5 };

		int count = 0;
		int max = 0;
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			set.add(arr[i]);
			count++;
			for (int j = i + 1; j < arr.length; j++) {
				set.add(arr[j]);
				if (set.size() <= 2) {
					count++;
				}
			}

			if (count > max) {
				max = count;
			}
			set.clear();
			count = 0;
		}

		System.out.println(max);

	}
}
