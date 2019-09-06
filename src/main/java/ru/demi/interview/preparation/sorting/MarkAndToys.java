package ru.demi.interview.preparation.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class MarkAndToys {

    static int maximumToys(int[] prices, int k) {
        int spent = 0;
        int count = 0;
        Arrays.sort(prices);
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] + spent > k) {
                break;
            }
            spent += prices[i];
            ++count;
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        int[] prices = new int[n];

        String[] pricesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int pricesItem = Integer.parseInt(pricesItems[i]);
            prices[i] = pricesItem;
        }

        int result = maximumToys(prices, k);
        System.out.println(result);

        scanner.close();
    }
}
