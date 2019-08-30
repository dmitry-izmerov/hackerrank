package ru.demi.akvelon;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Arrange the words
 */
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

        Arrays.sort(split, Comparator.comparingInt(String::length));

        char[] first = split[0].toCharArray();
        first[0] = Character.toUpperCase(first[0]);
        split[0] = new String(first);

        return String.join(" ", split) + ".";
    }
}
