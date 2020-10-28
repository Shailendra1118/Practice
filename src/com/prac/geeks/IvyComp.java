/**
 * 
 */
package com.prac.geeks;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author Shailendra
 *
 */
public class IvyComp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Employee e = new Employee();
		// newspaper post - all words and their frequency

		String input = "dog man cat see word man cat";
		String[] words = input.split(" ");
		String regex = "[a-z]"; //
		Map<String, Integer> map = new HashMap<>();
		for (String word : words) {
			if (map.containsKey(word)) {
				map.put(word, map.get(word) + 1);
			} else {
				map.put(word, 1);
			}
		}

		Iterator<Entry<String, Integer>> iter = map.entrySet().iterator();
		while (iter.hasNext()) {
			Entry e = iter.next();
			System.out.println(e.getKey() + ": " + e.getValue());
		}
	}

	static class Employee {
		String name;
		static int count = 0;

		public int getCount() {
			return count;
		}

		public Employee() {
			count++;
		}
	}

}
