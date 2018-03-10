package ru.demi.algorithms.bitmanipulation;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/lonely-integer/problem
 */
public class LonelyInteger {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];
		for(int a_i = 0; a_i < n; a_i++){
			a[a_i] = in.nextInt();
		}
		int result = getLonelyInteger(a);
		System.out.println(result);
	}

	private static int getLonelyInteger(int[] a) {
		if (a.length == 1) {
			return a[0];
		}

		Arrays.sort(a);

		for (int i = 0; i < a.length - 1; i++) {
			if ((a[i] ^ a[i + 1]) != 0) { // based on the following XOR property: x^x = 0
				if (i == 0 || (a[i - 1] ^ a[i]) != 0) {
					return a[i];
				}

				if (i + 1 == a.length - 1 || (a[i + 1] ^ a[i + 2]) != 0) {
					return a[i + 1];
				}
			}
		}

		return -1;
	}
}
