package ru.demi.algorithms.search;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

/**
 * Unsolved
 * https://www.hackerrank.com/challenges/sherlock-and-array/problem
 */
public class SherlockAndArray {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int a0 = 0; a0 < T; a0++){
            int n = in.nextInt();
            int[] a = new int[n];
            for(int a_i=0; a_i < n; a_i++){
                a[a_i] = in.nextInt();
            }
            String result = solve(a);
            System.out.println(result);
        }
        in.close();
    }

    static int RANGE = 500;
    static int CACHE_LIMIT = 1000;

    static String solve(int[] a){
        //long now = System.currentTimeMillis();

        if (a.length == 1)
            return "YES";

        String result = "NO";

        if (a.length < CACHE_LIMIT) {
            for (int i = 1; i < a.length - 1; i++) {
                int left = 0;
                for (int j = 0; j < i; j++) {
                    left += a[j];
                }
                int right = 0;
                for (int j = i + 1; j < a.length; j++) {
                    right += a[j];
                }

                if (left == right) {
                    result = "YES";
                }
            }
        }

        Map<Integer, Integer> cache = new HashMap<>();

        int cacheSum = 0;
        for (int i = 0; i < a.length; i++) {
            int forRange = i - RANGE;
            if (i > 0 && forRange >= 0 && i % RANGE == 0 && !cache.containsKey(forRange)) {
                int sum = cacheSum;
                int prevRange = forRange;
                while ((prevRange = prevRange - RANGE) >= 0) {
                    sum -= cache.get(prevRange);
                }
                cache.put(forRange, sum);
            }
            cacheSum += a[i];
        }

        for (int i = 1; i < a.length - 1; i++) {
            int left = 0;
            for (int j = 0; j < i; j++) {
                int iRangeFactor = i / RANGE;
                int startIRange = iRangeFactor * RANGE;
                int endIRange = (iRangeFactor + 1) * RANGE;
                boolean inRangeWithI = j >= startIRange && j < endIRange;
                if (inRangeWithI) {
                    left += a[j];
                } else if (j % RANGE == 0 && cache.containsKey(j)) {
                    left += cache.get(j);
                    j += RANGE - 1;
                } else {
                    left += a[j];
                }
            }

            int right = 0;
            for (int j = i + 1; j < a.length; j++) {
                int iRangeFactor = i / RANGE;
                int startIRange = iRangeFactor * RANGE;
                int endIRange = (iRangeFactor + 1) * RANGE;
                boolean inRangeWithI = j >= startIRange && j < endIRange;
                if (inRangeWithI) {
                    right += a[j];
                } else if (j % RANGE == 0 && cache.containsKey(j)) {
                    right += cache.get(j);
                    j += RANGE - 1;
                } else {
                    right += a[j];
                }
            }

            if (left == right) {
                result = "YES";
            }
        }

        //System.out.printf("Work time in ms: %d%n", System.currentTimeMillis() - now);

        return result;
    }
}
