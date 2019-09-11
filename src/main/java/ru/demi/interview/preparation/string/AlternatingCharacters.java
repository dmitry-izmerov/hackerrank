package ru.demi.interview.preparation.string;

import java.util.Scanner;

public class AlternatingCharacters {

    static int alternatingCharacters(String s) {
        StringBuilder sb = new StringBuilder(s);
        int deletions = 0;
        String pattern = "AB";
        if (s.charAt(0) == 'B') {
            pattern = "BA";
        }
        for (int i = 0, j = 0; i < sb.length(); i++) {
            if (sb.charAt(i) != pattern.charAt(j)) {
                sb.deleteCharAt(i);
                ++deletions;
                --i;
            } else {
                ++j;
                j %= 2;
            }
        }

        return deletions;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = alternatingCharacters(s);
            System.out.println(result);
        }
        scanner.close();
    }
}
