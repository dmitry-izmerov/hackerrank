package ru.demi.interview.preparation.sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FraudulentActivityNotifications {

    static int activityNotifications(int[] expenditure, int d) {
        if (d >= expenditure.length) {
            return 0;
        }
        LinkedList<Integer> list = null;
        int notifications = 0;
        for (int i = d; i < expenditure.length; i++) {
            if (list == null) {
                list = Arrays.stream(Arrays.copyOfRange(expenditure, i - d, i))
                    .boxed()
                    .collect(Collectors.toCollection(LinkedList::new));
            } else {
                list.removeFirst();
                list.addLast(expenditure[i]);
            }
            Collections.sort(list);
            double median = 0;
            if (d % 2 != 0) {
                median = list.get((d / 2));
            } else {
                median = (list.get((d / 2) - 1) + list.get(d / 2)) / 2d;
            }
            if (expenditure[i] >= median * 2) {
                ++notifications;
            }
        }

        return notifications;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications(expenditure, d);
        System.out.println(result);

        scanner.close();
    }
}
