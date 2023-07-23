package com.freestrokes.practice.softeer.level2;

import java.sql.Array;
import java.util.*;
import java.io.*;

/**
 * 금고털이 (Safe Breaker)
 *
 * 난이도: 2
 *
 * 문제:
 * 루팡은 배낭을 하나 메고 은행금고에 들어왔다. 금고 안에는 값비싼 금, 은, 백금 등의 귀금속 덩어리가 잔뜩 들어있다.
 * 배낭은 W ㎏까지 담을 수 있다.
 *
 * 각 금속의 무게와 무게당 가격이 주어졌을 때 배낭을 채울 수 있는 가장 값비싼 가격은 얼마인가?
 *
 * 루팡은 전동톱을 가지고 있으며 귀금속은 톱으로 자르면 잘려진 부분의 무게만큼 가치를 가진다.
 *
 * 제약조건:
 * 1 ≤ N ≤ 106인 정수
 * 1 ≤ W ≤ 104인 정수
 * 1 ≤ Mi, Pi ≤ 104인 정수
 *
 * 입력형식:
 * 첫 번째 줄에 배낭의 무게 W와 귀금속의 종류 N이 주어진다.
 * i + 1 (1 ≤ i ≤ N)번째 줄에는 i번째 금속의 무게 Mi와 무게당 가격 Pi가 주어진다.
 *
 * 출력형식:
 * 첫 번째 줄에 배낭에 담을 수 있는 가장 비싼 가격을 출력하라.
 *
 * 입력예제:
 * 100 2
 * 90 1
 * 70 2
 *
 * 출력예제:
 * 170
 *
 * 출처:
 * https://www.softeer.ai/practice/info.do?idx=1&eid=395
 *
 * 참고:
 * https://january-diary.tistory.com/entry/Softeer-%EA%B8%88%EA%B3%A0%ED%84%B8%EC%9D%B4-JAVA
 * https://velog.io/@frobenius/Softeer-%EA%B8%88%EA%B3%A0%ED%84%B8%EC%9D%B4-java
 *
 */
public class SafeBreaker {

    public static int N, W, availableWeight, totalValue;
    public static int[] jewelArr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<int[]> jewelList = new ArrayList<>();

        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        availableWeight = N;

        for (int i = 0; i < W; i++) {
            jewelArr = new int[2];
            st = new StringTokenizer(br.readLine());
            jewelArr[0] = Integer.parseInt(st.nextToken()); // 귀금속 무게
            jewelArr[1] = Integer.parseInt(st.nextToken()); // 귀금속 가격(kg당)
            jewelList.add(jewelArr);
        }

        jewelList.sort((a, b) -> b[1] - a[1]);

        jewelList.forEach(item -> {
            if (availableWeight > 0) {
                if (item[0] <= availableWeight) {
                    totalValue += item[0] * item[1];
                } else {
                    totalValue += availableWeight * item[1];
                }
                availableWeight -= item[0];
            }
        });

        System.out.println(totalValue);

    }

}
