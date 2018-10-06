package ru.demi.interview.preparation.arrays;

import java.util.Scanner;

/**
 * Calculate the maximum hourglass sum in the array.
 */
public class MaxHourGlassSum {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = getMaxHourglassSum(arr);
        System.out.println(result);

        scanner.close();
    }

    private static int getMaxHourglassSum(int[][] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = 0; j < arr[i].length - 2; j++) {
                int firstColSum = arr[i][j] + arr[i][j + 1] + arr[i][j + 2];
                int secondColSum = arr[i + 1][j + 1];
                int thirdColSum = arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];
                int sum = firstColSum + secondColSum + thirdColSum;
                if (sum > max) {
                    max = sum;
                }
            }
        }

        return max;
    }
}