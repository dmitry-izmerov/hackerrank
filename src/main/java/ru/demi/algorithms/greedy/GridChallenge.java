package ru.demi.algorithms.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class GridChallenge {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			int n = in.nextInt();
			String[] grid = new String[n];
			for (int grid_i = 0; grid_i < n; grid_i++){
				grid[grid_i] = in.next();
			}
			String result = gridChallenge(grid);
			System.out.println(result);
		}
		in.close();
	}

	private static String gridChallenge(String[] grid) {
		for (int i = 0; i < grid.length; i++) {
			char[] chars = grid[i].toCharArray();
			Arrays.sort(chars);
			grid[i] = new String(chars);
		}

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length() - 1; j++) {
				if (grid[i].charAt(j) > grid[i].charAt(j + 1)) {
					return "NO";
				}
			}
		}

		for (int j = 0; j < grid[0].length(); j++) {
			for (int i = 0; i < grid.length - 1; i++) {
				if (grid[i].charAt(j) > grid[i + 1].charAt(j)) {
					return "NO";
				}
			}
		}

		return "YES";
	}
}
