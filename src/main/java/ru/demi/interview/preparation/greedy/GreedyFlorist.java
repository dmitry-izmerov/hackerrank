package ru.demi.interview.preparation.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class GreedyFlorist {

    static int getMinimumCost(int k, int[] c) {
        int people = k;
        int size = (c.length % k == 0) ? c.length / k : c.length / k + 1;
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < people; i++) {
            lists.add(new ArrayList<>());
        }

        int[] prices = Arrays.stream(c).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
        int whichList = 0;
        for (int i = 0; i < prices.length; i++) {
            lists.get(whichList).add(prices[i]);
            ++whichList;
            whichList %= people;
        }

        int res = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < people; j++) {
                List<Integer> list = lists.get(j);
                if (i < list.size()) {
                    res += (i + 1) * list.get(i);
                }
            }
        }

        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int minimumCost = getMinimumCost(k, c);
        System.out.println(minimumCost);
        scanner.close();
    }
}
