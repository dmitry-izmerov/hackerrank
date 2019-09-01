package ru.demi.interview.preparation.dictionaries_and_hashmaps;

import java.util.Scanner;

public class TwoStrings {

    static String twoStrings(String s1, String s2) {
        char c = 'a';
        for (int i = c; i < 26 + c; i++) {
            if (s1.indexOf(i) > -1 && s2.indexOf(i) > -1) {
                return "YES";
            }
        }

        return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();

            String result = twoStrings(s1, s2);
            System.out.println(result);
        }

        scanner.close();
    }
}
