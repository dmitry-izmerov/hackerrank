package ru.demi.algorithms.bitmanipulation;

import java.util.HashMap;
import java.util.Scanner;

import java.util.Map;

/**
 * Unsolved
 * https://www.hackerrank.com/challenges/sum-vs-xor/problem
 */
public class SumVsXOR {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long n = in.nextLong();
		long result = solve(n);
		System.out.println(result);
	}

	private static Map<String, Long> cache = new HashMap<>();

	private static long solve(long n) {
		int r = 0;
		for (long x = 0; x <= n; x++) {
			/*Long xor;

			String key = "" + n + x;
			if (((xor = cache.get(key)) == null) && ((xor = cache.get("" + x + n)) == null)) {
				xor = n ^ x;
				cache.put(key, xor);
			}*/

			if ((n + x) == (n + x)) {
				++r;
			}
		}

		return r;
	}

	// 1000000000000000
	// 1073741824

	// 3434444444333
	// 262144

	// 1111111113456
	// 16777216
}
