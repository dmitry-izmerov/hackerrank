package ru.demi.interview.preparation.arrays;

public class MinimumSwaps2 {

    public static void main(String[] args) {
        System.out.println(minimumSwaps(new int[] { 4, 3, 1, 2 })); // 3
        System.out.println(minimumSwaps(new int[] { 2, 3, 4, 1, 5 })); // 3
        System.out.println(minimumSwaps(new int[] { 1, 3, 5, 2, 4, 6, 7 })); // 3
    }

    private static int minimumSwaps(int[] arr) {
        int swaps = 0;
        for (int i = 0; i < arr.length;) {
            int order = i + 1;
            if (arr[i] != order) {
                swap(i, arr[i] - 1, arr);
                ++swaps;
            } else {
                ++i;
            }
        }
        return swaps;
    }

    private static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
