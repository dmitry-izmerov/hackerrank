package ru.demi.interview.preparation.dictionaries_and_hashmaps;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SherlockAndAnagrams {

    static int sherlockAndAnagrams(String s) {
        List<Pair<String, String>> result = new ArrayList<>();

        int to = s.length() - 1;
        for (int i = 1; i <= to; i++) {
            for (int j = 0; j < s.length() - i; j++) {
                for (int k = j + 1; k <= s.length() - i; k++) {
                    String first = s.substring(j, j + i);
                    String second = s.substring(k, k + i);
                    if (isAnagram(first, second)) {
                        result.add(new Pair<>(first, second));
                    }
                }
            }
        }

        return result.size();
    }

    private static boolean isAnagram(String firstStr, String secondStr) {
        if (firstStr.length() != secondStr.length()) {
            return false;
        }
        char[] first = firstStr.toCharArray();
        char[] second = secondStr.toCharArray();

        Arrays.sort(first);
        Arrays.sort(second);

        for (int i = 0; i < first.length; i++) {
            if (first[i] != second[i]) {
                return false;
            }
        }
        return true;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);
            System.out.println(result);
        }

        scanner.close();
    }
}
