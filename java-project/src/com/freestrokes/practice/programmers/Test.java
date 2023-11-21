package com.freestrokes.practice.programmers;

import java.io.*;
import java.util.*;

public class Test {

    // 메인 메서드 실행을 위해선 control + shift + r 또는 run 실행.

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
