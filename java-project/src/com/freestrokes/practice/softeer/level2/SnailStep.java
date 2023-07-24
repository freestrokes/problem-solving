package com.freestrokes.practice.softeer.level2;

import java.util.*;
import java.io.*;

public class SnailStep {

    public static int W, D, r, c, step = 0;
    public static int[][] squareArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken()); // 너비 (Width)
        D = Integer.parseInt(st.nextToken()); // 깊이 (Depth)

        st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken()); // x 좌표
        c = Integer.parseInt(st.nextToken()); // y 좌표

        squareArr = new int[W][D];

        // 배열 초기화
        for (int i = 0; i < W; i++) {
            for (int j = 0; j < D; j++) {
                squareArr[i][j] = 0;
            }
        }

    }

}
