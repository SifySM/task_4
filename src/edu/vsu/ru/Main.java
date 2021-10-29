package edu.vsu.ru;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int num = readNumber();

        if (num < 101) {
            writeNumberLessThan101(num);
        } else {
            int number = findNumberMoreThan101(num);
            writeNumberMoreThan101(number);
        }
    }

    static int readNumber() {
        int n;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter what \"monotone\" number you want to find: ");
        System.out.print("n = ");

        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Re-enter the data.");
            System.out.print("n = ");
            scanner.next();
        }

        n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Invalid input. Re-enter the data.");
            return readNumber();
        }
        return n;
    }
    
    static int findNumberMoreThan101(double num) {
        int k = 100;
        int number = 100;
        while (k != num) {
            boolean a = checkMonotonicityOfNumber(number);
            if (a) {
                ++k;
            }
            ++number;
        }
        return number;
    }

    static void writeNumberLessThan101(int num) {
        System.out.println("n-th \"monotone\" integer = " + (num - 1));
    }

    static void writeNumberMoreThan101(int number) {
        System.out.println("n-th \"monotone\" integer = " + number);
    }

    public static boolean checkMonotonicityOfNumber(int number) {
        EMonotone monotone = EMonotone.Equals;

        for (int next, previous = number % 10; (number /= 10) != 0; previous = next) {
            next = number % 10;

            switch (monotone) {
                case Equals -> {
                    if (next > previous) {
                        monotone = EMonotone.Ascending;
                    } else if (next < previous) {
                        monotone = EMonotone.Descending;
                    }
                }

                case Ascending -> {
                    if (next < previous) {
                        return false;
                    }
                }

                case Descending -> {
                    if (next > previous) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
