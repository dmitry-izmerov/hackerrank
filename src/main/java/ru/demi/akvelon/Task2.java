package ru.demi.akvelon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.joining;

/**
 * Counting bits
 */
public class Task2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> result = getOneBits(n);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
                + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }

    static List<Integer> getOneBits(int n) {
        int count = 0;
        int pos = 0;
        List<Integer> l = new ArrayList<>();
        while (n > 0) {
            if ((n & 1) == 1) {
                count += 1;
                l.add(pos);
            }
            n >>= 1;
            ++pos;
        }

        int allPos = pos;

        List<Integer> res = new ArrayList<>(l.size() + 1);
        res.add(count);
        for (int i = l.size() - 1; i >= 0; --i) {
            res.add(allPos - l.get(i));
        }

        return res;
    }
}
