package com.freestrokes.practice.softeer;

import java.util.*;
import java.io.*;

public class Test {

    // public static int value1;
    // public static int value2;
    // public static int value3;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int value1 = Integer.parseInt(st.nextToken());
        int value2 = Integer.parseInt(st.nextToken());
        int value3 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());

        int value4 = Integer.parseInt(st.nextToken());
        int value5 = Integer.parseInt(st.nextToken());

        System.out.println("value1: " + value1);
        System.out.println("value2: " + value2);
        System.out.println("value3: " + value3);

        System.out.println("value4: " + value4);
        System.out.println("value5: " + value5);

        int count = 10;

        System.out.println(recursiveCalc(count));

        double doubleValue = 0.00D;
        float floatValue = 0.00F;

        System.out.printf("%.2f\n", doubleValue);
    }

    public static long recursiveCalc(int count) {
        System.out.println("count: " + count);

        if (count == 0) {
            return count;
        } else {
            count--;
            return recursiveCalc(count);
        }
    }

}
