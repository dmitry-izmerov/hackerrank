package ru.demi.akvelon;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Anagram difference
 */
public class Task3 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = null;
        if (fileName != null) {
            bw = new BufferedWriter(new FileWriter(fileName));
        }
        else {
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        int a_size = 0;
        a_size = Integer.parseInt(in.nextLine().trim());

        String[] a = new String[a_size];
        for(int i = 0; i < a_size; i++) {
            String a_item;
            try {
                a_item = in.nextLine();
            } catch (Exception e) {
                a_item = null;
            }
            a[i] = a_item;
        }

        int b_size = 0;
        b_size = Integer.parseInt(in.nextLine().trim());

        String[] b = new String[b_size];
        for(int i = 0; i < b_size; i++) {
            String b_item;
            try {
                b_item = in.nextLine();
            } catch (Exception e) {
                b_item = null;
            }
            b[i] = b_item;
        }

        List<Integer> res = getMinimumDifference(Arrays.asList(a), Arrays.asList(b));
        for(int res_i = 0; res_i < res.size(); res_i++) {
            bw.write(String.valueOf(res.get(res_i)));
            bw.newLine();
        }

        bw.close();
    }

    static List<Integer> getMinimumDifference(List<String> a, List<String> b) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < a.size(); i++) {
            String first = a.get(i);
            String second = b.get(i);

            if (first.length() != second.length()) {
                result.add(-1);
                continue;
            }

            int[] charsCount = new int[26];
            for (int j = 0; j < first.length(); j++) {
                ++charsCount[first.charAt(j) - 'a'];
            }

            int count = 0;
            for (int j = 0; j < second.length(); j++) {
                if (--charsCount[second.charAt(j) - 'a'] < 0) {
                    ++count;
                }
            }
            result.add(count);
        }

        return result;
    }
}
