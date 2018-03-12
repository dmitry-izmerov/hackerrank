package ru.demi.akvelon;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task2 {
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
        int n;
        n = Integer.parseInt(in.nextLine().trim());

        res = getOneBits(n);
        for(int res_i = 0; res_i < res.length; res_i++) {
            bw.write(String.valueOf(res[res_i]));
            bw.newLine();
        }

        bw.close();
    }

    static int[] getOneBits(int n) {
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

        int[] ar = new int[l.size() + 1];
        ar[0] = count;
        for (int i = l.size() - 1, j = 1; i >= 0; --i, ++j) {
            ar[j] = allPos - l.get(i);
        }

        return ar;
    }
}
