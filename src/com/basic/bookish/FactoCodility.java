/**
 * 
 */
package com.basic.bookish;

import java.math.BigInteger;

/**
 * @author Shailendra
 *
 */
public class FactoCodility {

	public static void main(String args[]) {

		FactoCodility f = new FactoCodility();
		long res = f.solution(3, 5);
		// long res = f.solution(40, 20);
		System.out.println(res);
	}

	public int solution(int N, int K) {
		// write your code in Java SE 8
		if (N < K)
			return -1;

		// int max = 1000000000;
		BigInteger max = new BigInteger("1000000000");
		BigInteger deno = fac(N - K).multiply(fac(K));
		BigInteger res = fac(N).divide(deno);

		if (res.compareTo(max) == 1) {
			return -1;
		} else {
			return res.intValue();
		}
	}

	private BigInteger fac(int a) {
		if (a == 1 || a == 0)
			return new BigInteger("1");

		BigInteger res = new BigInteger("1");
		for (int i = a; i > 0; i--) {
			res = res.multiply(new BigInteger(String.valueOf(i)));
			// res = res * i;
		}
		// System.out.println("a: " + a + " res: " + res);
		return res;
	}
}
