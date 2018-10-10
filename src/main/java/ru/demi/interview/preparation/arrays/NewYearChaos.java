package ru.demi.interview.preparation.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Complete the function which must print an integer representing the minimum number of bribes necessary,
 * or Too chaotic if the line configuration is not possible.
 */
public class NewYearChaos {

    private static final String BAD_CASE_MESSAGE = "Too chaotic";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }

    private static void minimumBribes(int[] ar) {
        List<Integer> nums = Arrays.stream(ar).boxed().collect(Collectors.toList());
        Map<Integer, Integer> swapCounter = new HashMap<>();

        int numSwaps = 0;
        int numSwapsPerIteration;
        do  {
            numSwapsPerIteration = 0;
            for (int i = 0; i < ar.length - 1; i++) {
                Integer left = nums.get(i);
                Integer right = nums.get(i + 1);

                if (left > right) {
                    if (swapCounter.getOrDefault(left, 0) == 2) {
                        System.out.println(BAD_CASE_MESSAGE);
                        return;
                    }
                    swapCounter.computeIfPresent(left, (k, v) -> v + 1);
                    swapCounter.putIfAbsent(left, 1);

                    nums.set(i + 1, left);
                    nums.set(i, right);
                    ++numSwapsPerIteration;
                }
            }
            numSwaps += numSwapsPerIteration;
        } while (numSwapsPerIteration != 0);

        System.out.println(numSwaps);
    }
}
