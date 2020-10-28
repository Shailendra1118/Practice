/**
 * 
 */
package com.basic.hkre.krypc;

import java.io.File;
import java.util.Scanner;

/**
 * @author Shailendra
 *
 */
public class Solution {

	public static void main(String args[]) throws Exception {

		// Scanner
		Scanner s = new Scanner(new File(
				"D:/Keppler/Practice/src/com/basic/hkre/krypc/input.txt"));
		int n = s.nextInt();
		int q = s.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}

		// System.out.println("size: " + arr.length);
		for (int i = 0; i < q; i++) {
			int query = s.nextInt();
			int res = process(arr, query);
			System.out.println(res);
		}

		s.close();

	}

	/**
	 * @param arr
	 * @param query
	 * @return
	 */
	private static int process(int[] arr, int k) {
		int numOfOnes = 0; // current
		int len = Integer.MAX_VALUE;
		int left = 0;
		boolean found = false;
		for (int right = 0; right < arr.length; right++) {

			numOfOnes = numOfOnes + countNumOfOnes(arr[right]);

			while (left <= right && numOfOnes > k) {
				len = Math.min(len, right - left + 1);
				numOfOnes = numOfOnes - countNumOfOnes(arr[left]);
				left++;

				if (k == numOfOnes) {
					found = true;
				}
			}

			if (k == numOfOnes) {
				found = true;
			}
		}
		if (found) {
			return len;
		} else
			return -1;
	}

	private static int countNumOfOnes(int n) {
		int count = 0;
		while (n > 0) {
			n = (n - 1) & n;
			count++;
		}
		// System.out.println("n: " + orig + "-" + count);
		return count;
	}
}
