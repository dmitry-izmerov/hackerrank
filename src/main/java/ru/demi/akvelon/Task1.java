package ru.demi.akvelon;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Task1 {
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

        String res;
        String sentence;
        try {
            sentence = in.nextLine();
        } catch (Exception e) {
            sentence = null;
        }

        res = arrange(sentence);
        bw.write(res);
        bw.newLine();

        bw.close();
    }

    static String arrange(String sentence) {
        String[] split = sentence.split(" ");
        split[0] = split[0].toLowerCase();
        StringBuilder stE = new StringBuilder(split[split.length - 1]);
        stE.deleteCharAt(split[split.length - 1].length() - 1);
        split[split.length - 1] = stE.toString();

        Arrays.sort(split, (a, b) -> a.length() - b.length());

        StringBuilder sb = new StringBuilder();
        char[] first = split[0].toCharArray();
        first[0] = Character.toUpperCase(first[0]);
        sb.append(new String(first));
        if (split.length > 1) {
            sb.append(' ');
        }

        for (int i = 1; i < split.length; i++) {
            sb.append(split[i]);

            if (i != split.length - 1) {
                sb.append(' ');
            }
        }

        sb.append('.');

        return sb.toString();
    }
}
