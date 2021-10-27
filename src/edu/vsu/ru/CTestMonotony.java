package edu.vsu.ru;

import java.util.Scanner;

public class CTestMonotony {
    public static void findMonotoneNumber(int num) {
        if (num < 101) {
            System.out.println("n-th \"monotone\" integer = " + (num - 1));
        } else {
            int k = 100;
            int number = 100;
            while (k != num) {
                int a = checkMonotonicityOfNumber(number);
                if (a == 1) {
                    ++k;
                }
                ++number;
            }
            System.out.println("n-th \"monotone\" integer = " + number);
        }
    }

    static int checkMonotonicityOfNumber(int number) {
        int previous = number % 10;
        number /= 10;
        int next = number % 10;
        number /= 10;

        while (previous == next) {
            next = number % 10;
            number /= 10;
        }

        if (!(number == 0)) {
            if (next < previous) {
                if (isAscendingSequence(number, next))
                    return 1;
            } else {
                if (isDescendingSequence(number, next))
                    return 1;
            }
        } else return 1;
        return 0;
    }

    static boolean isAscendingSequence(int number, int next) {
        while (number > 0) {
            int previous = next;
            next = number % 10;
            if (next > previous) {
                return false;
            }
            number /= 10;
        }
        return true;
    }

    static boolean isDescendingSequence(int number, int next) {
        while (number >= 1) {
            int previous = next;
            next = number % 10;
            if (next < previous) {
                return false;
            }
            number /= 10;
        }
        return true;
    }
}
