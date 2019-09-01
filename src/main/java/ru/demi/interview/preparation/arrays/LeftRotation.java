package ru.demi.interview.preparation.arrays;

import java.util.Scanner;

public class LeftRotation {
    static int[] rotLeft(int[] ar, int leftRotations) {
        int[] res = new int[ar.length];

        for (int i = 0; i < ar.length; i++) {
            int newPos;
            if ((newPos = i - leftRotations) < 0) {
                newPos = ar.length + (newPos % ar.length);
            }
            res[newPos] = ar[i];
        }
        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] result = rotLeft(a, d);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

        scanner.close();
    }
}
