package ru.demi.interview.preparation.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MakingAnagrams {

    static int makeAnagram(String a, String b) {
        Map<Character, Integer> charCounter = new HashMap<>();
        int counter = 0;
        char[] first = a.toCharArray();
        char[] second = b.toCharArray();
        Arrays.sort(first);
        Arrays.sort(second);
        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            charCounter.computeIfPresent(c, (k, oldVal) -> oldVal + 1);
            charCounter.putIfAbsent(c, 1);
        }
        for (int i = 0; i < b.length(); i++) {
            char c = b.charAt(i);
            charCounter.computeIfPresent(c, (k, oldVal) -> oldVal - 1);
            charCounter.putIfAbsent(c, -1);
        }

        for (int val : charCounter.values()) {
            counter += Math.abs(val);
        }

        return counter;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String a = scanner.nextLine();
        String b = scanner.nextLine();

        int res = makeAnagram(a, b);
        System.out.println(res);

        scanner.close();
    }
}
