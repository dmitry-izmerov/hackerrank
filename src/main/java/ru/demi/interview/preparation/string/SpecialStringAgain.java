package ru.demi.interview.preparation.string;

import java.util.Scanner;

/**
 * TODO: try to optimize solution by time complexity
 */
public class SpecialStringAgain {

    static long substrCount(int n, String s) {
        long count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String substr = s.substring(i, j);
                if (isSpecial(substr)) {
                    ++count;
                }
            }
        }

        return count;
    }

    private static boolean isSpecial(String str) {
        if (str.length() == 1) {
            return true;
        }

        boolean isOdd = str.length() % 2 == 1;
        char first = str.charAt(0);
        int count = 1;
        boolean isMiddle = false;
        for (int i = 1; i < str.length(); i++) {
            if (first == str.charAt(i)) {
                ++count;
            } else if (isOdd && i == str.length() / 2) {
                isMiddle = true;
            }
        }
        return count == str.length() || (count == (str.length() - 1) && isMiddle);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        long result = substrCount(n, s);
        System.out.println(result);

        scanner.close();
    }
}
