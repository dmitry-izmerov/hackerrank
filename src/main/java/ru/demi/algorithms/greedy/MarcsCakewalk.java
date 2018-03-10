package ru.demi.algorithms.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * https://www.hackerrank.com/challenges/marcs-cakewalk/problem
 */
public class MarcsCakewalk {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] calorie = new int[n];
		for(int calorie_i = 0; calorie_i < n; calorie_i++){
			calorie[calorie_i] = in.nextInt();
		}
		long result = marcsCakewalk(calorie);
		System.out.println(result);
		in.close();
	}

	private static long marcsCakewalk(int[] calorie) {
		Integer[] ar = IntStream.of(calorie).boxed().toArray(Integer[]::new);
		Arrays.sort(ar, Comparator.reverseOrder());

		long sum = 0;

		for (int i = 0; i < ar.length; i++) {
			sum += ar[i] * Math.pow(2, i);
		}

		return sum;
	}

}
