package ru.demi.algorithms.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/minimum-absolute-difference-in-an-array/problem
 */
public class MinAbsoluteDiffInArray {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		for(int arr_i = 0; arr_i < n; arr_i++){
			arr[arr_i] = in.nextInt();
		}
		int result = minimumAbsoluteDifference(n, arr);
		System.out.println(result);
		in.close();
	}

	static int minimumAbsoluteDifference(int n, int[] arr) {
		Integer[] ar = Arrays.stream(arr).boxed().toArray(Integer[]::new);
		Arrays.sort(ar, Comparator.comparingInt(Math::abs));

		int r = Integer.MAX_VALUE;

		for (int i = 0; i < ar.length - 1; i++) {
			int diff = Math.abs(ar[i] - ar[i + 1]);

			if (diff < r) {
				r = diff;
			}
		}

		return r;
	}
}
