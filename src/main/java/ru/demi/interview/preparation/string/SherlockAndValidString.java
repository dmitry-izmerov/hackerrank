package ru.demi.interview.preparation.string;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SherlockAndValidString {

    static String isValid(String s) {
        Map<Character, Integer> charCounter = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            charCounter.compute(c, (k, v) -> v == null ? 1 : v + 1);
        }

        Collection<Integer> values = charCounter.values();
        Map<Integer, Long> occurrences = values.stream()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        if (occurrences.size() == 1) {
            return "YES";
        }

        if (occurrences.size() == 2) {
            List<Map.Entry<Integer, Long>> entries = new ArrayList<>(occurrences.entrySet());
            Map.Entry<Integer, Long> almostAll = entries.get(0);
            Map.Entry<Integer, Long> exceptionalOne = entries.get(1);
            if (entries.get(0).getValue() < entries.get(1).getValue()) {
                almostAll = entries.get(1);
                exceptionalOne = entries.get(0);
            }

            if (exceptionalOne.getValue() == 1 && ((exceptionalOne.getKey() - almostAll.getKey() == 1) || exceptionalOne.getKey() == 1)) {
                return "YES";
            }
        }

        return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String s = scanner.nextLine();

        String result = isValid(s);
        System.out.println(result);

        scanner.close();
    }
}
