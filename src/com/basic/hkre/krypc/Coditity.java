/**
 * 
 */
package com.basic.hkre.krypc;

/**
 * @author Shailendra
 *
 */
public class Coditity {

	public static void main(String args[]) {
		int res = solution(1, 1, 2, 3);
		System.out.println(res);
	}

	public static int solution(int A, int B, int C, int D) {
		// write your code in Java SE 8
		// pick one and check difference with others
		int arr[] = new int[4];
		arr[0] = A;
		arr[1] = B;
		arr[2] = C;
		arr[3] = D;

		// pick first i.e A
		int max = Integer.MIN_VALUE;
		int idx = -1;
		for (int i = 1; i < arr.length; i++) {
			int cur = Math.abs(A - arr[i]);
			if (cur > max) {
				max = cur;
				idx = i;
			}
		}

		boolean start = false;
		int other = -1;
		for (int i = 1; i < arr.length; i++) {
			if (i != idx) {
				if (!start) {
					other = arr[i];
					start = true;
				} else {
					other = other - arr[i];
				}
			}
		}

		int res = (int) (Math.pow(Math.abs(A - arr[idx]), 2) + Math.pow(
				Math.abs(other), 2));

		return res;
	}
}