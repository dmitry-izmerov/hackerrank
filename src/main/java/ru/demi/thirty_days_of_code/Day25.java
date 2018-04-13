package ru.demi.thirty_days_of_code;

import java.util.Scanner;

/**
 * Small theory - https://www.hackerrank.com/challenges/30-running-time-and-complexity/tutorial
 * used book - <a href='https://www.amazon.com/Algorithms-Sequential-Parallel-Unified-Approach/dp/1133366805'>algorithms book</a>
 *
 * Task:
 * A prime is a natural number greater than 1 that has no positive divisors other than 1 and itself.
 * Given a number n, determine and print whether it's Prime or Not prime.
 */
public class Day25 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            System.out.println(isPrime(num) ? "Prime" : "Not prime");
        }
    }

    private static boolean isPrime(int num) {
        if(num == 1){
            return false;
        }
        if(num == 2){
            return true;
        }
        if ((num & 1) == 0) {
            return false;
        }

        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
