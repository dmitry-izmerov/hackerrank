package ru.demi.interview.preparation.sorting;

import java.util.Arrays;
import java.util.Scanner;

/**
 * TODO: improve solution
 */
public class CountingInversions {

    static long countInversions(int[] arr) {
        int[] sorted = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sorted);

        long res = 0;
        for (int i = 0; i < sorted.length; i++) {
            int current = sorted[i];
            for (int j = i; j < arr.length; j++) {
                if (current == arr[j]) {
                    swapTo(j, i, arr);
                    res += j - i;
                    break;
                }
            }
        }

        return res;
    }
    
    private static void swapTo(int from, int to, int[] ar) {
        for (int i = from; i > to; --i) {
            int temp = ar[i - 1];
            ar[i - 1] = ar[i];
            ar[i] = temp;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String str = scanner.nextLine();
            String[] arrItems = str.split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            long result = countInversions(arr);
            System.out.println(result);
        }

        scanner.close();
    }
}
