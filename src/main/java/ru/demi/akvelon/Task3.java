package ru.demi.akvelon;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * Unsolved
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

        int[] res;
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

        res = getMinimumDifference(a, b);
        for(int res_i = 0; res_i < res.length; res_i++) {
            bw.write(String.valueOf(res[res_i]));
            bw.newLine();
        }

        bw.close();
    }

    static int[] getMinimumDifference(String[] a, String[] b) {
        int[] r = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            if (a[i].length() != b[i].length()) {
                r[i] = -1;
                continue;
            }

            String s1 = new StringBuilder(a[i]).reverse().toString();
            String s2 = new StringBuilder(b[i]).reverse().toString();

            if (s1.equals(b[i]) || s2.equals(a[i])) {
                r[i] = 0;
                continue;
            }

            int c = 0;
            for (int j = 0; j < a[i].length(); j++) {
                if (a[i].charAt(j) != s2.charAt(j) || s1.charAt(j) != b[i].charAt(j)) {
                     ++c;
                }
            }
            r[i] = c;
        }

        return r;
    }
}
