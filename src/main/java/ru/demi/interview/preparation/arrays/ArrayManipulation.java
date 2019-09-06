package ru.demi.interview.preparation.arrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 * TODO: improve solution
 */
public class ArrayManipulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);
        System.out.println(result);
        scanner.close();
    }

    private static long arrayManipulation(int n, int[][] queries) {
        long[] arr = new long[n];

        for (int i = 0; i < queries.length; i++) {
            for (int j = queries[i][0] - 1; j < queries[i][1]; j++) {
                arr[j] += queries[i][2];
            }
        }
        
        return Arrays.stream(arr).max().getAsLong();
    }
}
