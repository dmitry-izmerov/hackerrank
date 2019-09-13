package ru.demi.interview.preparation.greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class LuckBalance {

    static int luckBalance(int k, int[][] contests) {
        int numOfContests = contests.length;
        int availableWins = numOfContests - k;
        int availableLoses = k;

        List<Integer> important = new ArrayList<>();
        List<Integer> unimportant = new ArrayList<>();
        for (int i = 0; i < numOfContests; i++) {
            int value = contests[i][0];
            if (contests[i][1] == 1) {
                important.add(value);
            } else {
                unimportant.add(value);
            }
        }
        important.sort(Comparator.naturalOrder());

        int res = 0;
        for (int i = 0; i < unimportant.size(); i++) {
            res += unimportant.get(i);
        }

        int losesInImportant = 0;
        int wins = 0;
        for (int i = 0, start = 0, end = important.size() - 1; i < important.size(); i++) {
            if (losesInImportant < availableLoses) {
                res += important.get(end);
                ++losesInImportant;
                --end;
            } else if (wins < availableWins) {
                res -= important.get(start);
                ++wins;
                ++start;
            }
        }
        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[][] contests = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] contestsRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int contestsItem = Integer.parseInt(contestsRowItems[j]);
                contests[i][j] = contestsItem;
            }
        }

        int result = luckBalance(k, contests);
        System.out.println(result);

        scanner.close();
    }
}
