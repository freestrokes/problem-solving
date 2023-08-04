package com.freestrokes.practice.softeer.level2;

import java.util.*;
import java.io.*;

/**
 * 로봇청소기2
 * - 2023 하반기 KEP 연계 채용 코딩 테스트 출제
 *
 * 난이도: 2
 *
 * 문제:
 *
 *
 * 제약조건:
 * 1 <= c <= W
 * 1 <= r <= D
 *
 * 입력형식:
 * 첫 번째 줄에 가로, 세로 길이 W, D가 주어지고, 두 번째 줄에 좌표 정보 c, r이 주어진다.
 *
 * 출력형식:
 * 주어진 좌표에 채워진 값을 출력한다.
 *
 * 입력예제:
 * 4 5
 * 3 4
 *
 * 출력예제:
 * 18
 *
 * 출처:
 *
 *
 * 참고:
 *
 *
 */
public class SnailStep {

    public static int W, D, r, c, i = 0, j = 0, step = 0, maxRight, maxLeft, maxUp, maxDown;
    public static int[][] squareArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken()); // 너비 (Width)
        D = Integer.parseInt(st.nextToken()); // 깊이 (Depth)

        st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken()); // x 좌표
        c = Integer.parseInt(st.nextToken()); // y 좌표

        squareArr = new int[D][W]; // ex) 5, 4
        maxDown = D; // ex) 4
        maxRight = W; // ex) 3
        maxLeft = -1;
        maxUp = 0;

        // 값 채우기
        while (step < W * D) {
            // 오른쪽으로 채우기
            if (i == maxUp && j < maxRight) {
                squareArr[i][j] = ++step;
                j++;

                if (j == maxRight) {
                    j--;
                    maxRight--;
                    i++;
                }
            }
            // 아래로 채우기
            if (i < maxDown && j == maxRight) {
                squareArr[i][j] = ++step;
                i++;

                if (i == maxDown) {
                    i--;
                    maxDown--;
                    j--;
                }
            }
            // 왼쪽으로 채우기
            if (i == maxDown && j > maxLeft) {
                squareArr[i][j] = ++step;
                j--;

                if (j == maxLeft) {
                    j++;
                    maxLeft++;
                    i--;
                }
            }
            // 위로 채우기
            if (i > maxUp && j == maxLeft) {
                squareArr[i][j] = ++step;
                i--;

                if (i == maxUp) {
                    i++;
                    maxUp++;
                    j++;
                }
            }
        }

        // TODO
//        for(int i = 0; i < D; i++) {
//            for(int j = 0; j < W; j++) {
//                System.out.printf("[%d] ", squareArr[i][j]);
//            }
//            System.out.println();
//        }

        System.out.println(squareArr[c-1][r-1]);

    }

}
