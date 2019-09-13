package ru.demi.interview.preparation.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

/**
 * TODO: unsolved
 */
public class CommonChild {

    static int commonChild(String s1, String s2) {
        Map<Character, List<Integer>> charPositions = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            final int index = i;
            charPositions.compute(s1.charAt(i), (k, v) -> {
                if (v == null) {
                    List<Integer> list = new ArrayList<>();
                    list.add(index);
                    return list;
                }
                v.add(index);
                return v;
            });
        }

        int max = 0;
        for (int i = 0; i < s2.length(); i++) {
            int res = 0;
            int prevIndex = -1;
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < s2.length(); j++) {
                char c = s2.charAt(j);
                List<Integer> positions = charPositions.get(c);
                if (positions == null) {
                    continue;
                }

                if (prevIndex == -1) {
                    prevIndex = positions.get(0);
                    ++res;
                    sb.append(c);
                    continue;
                }

                final int pIndex = prevIndex;
                Optional<Integer> first = positions.stream().filter(position -> position > pIndex).findFirst();
                if (!first.isPresent()) {
                    continue;
                }

                prevIndex = first.get();
                ++res;
                sb.append(c);
            }
            if (res > max) {
                max = res;
            }
            System.out.printf("Got substring: %s%n", sb);
        }

        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();

        int result = commonChild(s1, s2);
        System.out.println(result);

        scanner.close();
    }
}
