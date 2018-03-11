package ru.demi.algorithms.recursion;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/the-power-sum/problem
 */
public class ThePowerSum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int X = in.nextInt();
        int N = in.nextInt();
        int result = powerSum(X, N);
        System.out.println(result);
        in.close();
    }

    private static int powerSum(int X, int N) {
        return countPowerSums(0, 1, X, N);
    }

    private static int countPowerSums(int prevSum, int start, int end, int power) {
        if (start > end) {
            return 0;
        }

        int count = 0;
        for (int i = start; i <= end - 1; i++) {
            int pow = (int) Math.pow(i, power);
            int res = prevSum + pow;

            if (res == end) {
                ++count;
            } else if (res < end) {
                count += countPowerSums(res, i + 1, end, power);
            }

            if (res > end) {
                break;
            }
        }

        return count;
    }
}
