package ru.demi.algorithms.bitmanipulation;

import java.util.Scanner;

public class MaximizingXOR {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int l = in.nextInt();
		int r = in.nextInt();
		int result = maximizingXor(l, r);
		System.out.println(result);
		in.close();
	}

	private static int maximizingXor(int l, int r) {
		int max = -1;
		for (int i = l; i <= r; i++) {
			for (int j = l; j <= r; j++) {
				int xor = i ^ j;
				if (xor > max) {
					max = xor;
				}
			}
		}

		return max;
	}
}
