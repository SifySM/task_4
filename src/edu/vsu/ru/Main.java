package edu.vsu.ru;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int num = CNumber.readNumber();
        CTestMonotony.findMonotoneNumber(num);
    }

}
