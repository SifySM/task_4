package edu.vsu.ru;

import java.util.Scanner;

public class CNumber {
    public static int readNumber() {
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
            System.out.print("Invalid input. Re-enter the data.");
            return readNumber();
        }
        return n;
    }
}
