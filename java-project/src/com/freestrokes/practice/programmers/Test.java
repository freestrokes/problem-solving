package com.freestrokes.practice.programmers;

import java.io.*;
import java.util.*;

public class Test {

    public static int a, b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        System.out.println("a: " + a);
        System.out.println("b: " + b);
    }

}
