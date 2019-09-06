package ru.demi.interview.preparation.dictionaries_and_hashmaps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class FrequencyQueries {

    static List<Integer> freqQuery(List<List<Integer>> queries) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>(queries.size() / 10);
        Map<Integer, Integer> frequencies = new HashMap<>(queries.size() / 10);

        for (int i = 0; i < queries.size(); i++) {
            List<Integer> pair = queries.get(i);
            int operation = pair.get(0);
            int value = pair.get(1);
            switch (operation) {
                case 1:
                    map.computeIfPresent(value, (key, oldValue) -> {
                        int newVal = oldValue + 1;

                        frequencies.computeIfPresent(oldValue, (k, oldFreq) -> {
                            Integer newFreq = oldFreq - 1;
                            if (newFreq == 0) {
                                newFreq = null;
                            }
                            return newFreq;
                        });

                        frequencies.computeIfPresent(newVal, (k, oldFreq) -> oldFreq + 1);
                        frequencies.putIfAbsent(newVal, 1);

                        return newVal;
                    });
                    map.computeIfAbsent(value, (key) -> {
                        frequencies.computeIfPresent(1, (k, oldValue) -> oldValue + 1);
                        frequencies.putIfAbsent(1, 1);
                        return 1;
                    });
                    break;
                case 2:
                    map.computeIfPresent(value, (key, oldValue) -> {
                        Integer newVal = oldValue - 1;

                        frequencies.computeIfPresent(oldValue, (k, oldFreq) -> {
                            Integer newFreq = oldFreq - 1;
                            if (newFreq == 0) {
                                newFreq = null;
                            }
                            return newFreq;
                        });

                        frequencies.computeIfPresent(newVal, (k, oldFreq) -> oldFreq + 1);
                        frequencies.putIfAbsent(newVal, 1);

                        if (newVal == 0) {
                            newVal = null;
                        }

                        return newVal;
                    });
                    break;
                case 3:
                    int check = 0;
                    if (frequencies.containsKey(value)) {
                        check = 1;
                    }
                    result.add(check);
                    break;
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> ans = freqQuery(queries);
        ans.forEach(System.out::println);

        bufferedReader.close();
    }
}
