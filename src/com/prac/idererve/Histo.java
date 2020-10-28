package com.prac.idererve;

import java.io.FileNotFoundException;
import java.util.Stack;

public class Histo {

	public static void main(String[] args) throws FileNotFoundException {
		int arr[] = { 6, 2, 5, 4, 5, 1, 6 };// {2, 1, 5, 6, 2, 3};
		Stack<Integer> stk = new Stack<>();
		if (arr.length == 0 || arr == null)
			return;
		int max = 0, i = 0;
		while (i < arr.length) {

			if (stk.isEmpty() || (!stk.isEmpty() && arr[i] >= arr[stk.peek()])) {
				stk.push(i++);
			} else {
				int p = stk.pop();
				int h = arr[p];
				System.out.println("h: " + h);
				// calculating area with top of the stack as smallest bar
				int w = stk.isEmpty() ? i : i - stk.peek() - 1;
				// h*w should exclude left most smallest bar and right most
				// smallest bar
				System.out.println("w: " + w + " max: " + max);
				max = Math.max(h * w, max);
				System.out.println("new max: " + max);
			}
			System.out.println(stk.toString());
			System.out.println("----");
		}

		// stack will contains index always in increasing order
		while (!stk.isEmpty()) {
			int p = stk.pop();
			int h = arr[p];
			int w = stk.isEmpty() ? i : i - stk.peek() - 1;
			max = Math.max(h * w, max);
		}

		System.out.println("Mx:" + max);
	}

}
