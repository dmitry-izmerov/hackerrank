package ru.demi.interview.preparation.dictionaries_and_hashmaps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * TODO: improve solution
 */
public class CountTriplets {

    static long countTriplets(List<Long> arr, long r) {
        Map<Long, Long> map = new HashMap<>();

        long counter = 0;
        for (int i = 0; i < arr.size(); i++) {
            long first = arr.get(i);
            if (first == 1 || first % r == 0) {
                for (int j = i + 1; j < arr.size(); j++) {
                    long second = arr.get(j);
                    if (second == 1 || (second % r == 0 && second == first * r)) {
                        for (int k = j + 1; k < arr.size(); k++) {
                            long third = arr.get(k);
                            if (third == 1 || (third % r == 0 && third == second * r)) {
                                ++counter;
                            }
                        }
                    }
                }
            }
        }

        return counter;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Long::parseLong)
            .collect(toList());

        System.out.println(countTriplets(arr, r));

        bufferedReader.close();
    }
}
