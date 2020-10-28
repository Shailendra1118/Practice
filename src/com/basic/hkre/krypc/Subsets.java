/**
 * 
 */
package com.basic.hkre.krypc;

/**
 * @author Shailendra
 *
 */
public class Subsets {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int set[] = { 1, 2, 3 };
		printSubsets(set);
	}

	/**
	 * @param set
	 */
	private static void printSubsets(int[] set) {
		int n = set.length;
		long M = (long) (Math.pow(10, 9) + 7);

		// Run a loop for printing all 2^n
		// subsets one by obe
		long sum = 0;
		for (int i = 0; i < (1 << n); i++) {

			// Print current subset
			int bitor = 0;
			for (int j = 0; j < n; j++) {
				// (1<<j) is a number with jth bit 1
				// so when we 'and' them with the
				// subset number we get which numbers
				// are present in the subset and which
				// are not
				if ((i & (1 << j)) > 0) {
					System.out.print(set[j] + " ");
					bitor = bitor | set[j];
				}
			}
			System.out.println();
			sum = sum + bitor;
		}

		System.out.println(sum % M);
	}
}
