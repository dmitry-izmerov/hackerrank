package ru.demi.interview.preparation.dictionaries_and_hashmaps;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RansomNote {
    static void checkMagazine(String[] magazine, String[] notes) {

        Map<String, Integer> wordsCount = new HashMap<>();
        for (int i = 0; i < magazine.length; i++) {
            wordsCount.computeIfPresent(magazine[i], (key, oldValue) -> ++oldValue);
            wordsCount.putIfAbsent(magazine[i], 1);
        }
        for (int i = 0; i < notes.length; i++) {
            Integer newVal = wordsCount.computeIfPresent(notes[i], (key, oldValue) -> --oldValue);
            if (newVal == null || newVal < 0) {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}
