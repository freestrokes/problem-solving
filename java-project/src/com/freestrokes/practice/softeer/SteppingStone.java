package com.freestrokes.practice.softeer;

import java.util.*;
import java.io.*;

/**
 * 징검다리 (Stepping Stone)
 *
 * 문제:
 * 남북으로 흐르는 개울에 동서로 징검다리가 놓여져 있다.
 * 이 징검다리의 돌은 들쑥날쑥하여 높이가 모두 다르다.
 * 철수는 개울의 서쪽에서 동쪽으로 높이가 점점 높은 돌을 밟으면서 개울을 지나가려고 한다.
 * 돌의 높이가 서쪽의 돌부터 동쪽방향으로 주어졌을 때 철수가 밟을 수 있는 돌의 최대 개수는?
 *
 * 제약조건:
 * 1 ≤ N ≤ 3×10^3 인 정수
 * 1 ≤ Ai ≤ 10^8 인 정수
 *
 * 입력형식:
 * 첫 번째 줄에 돌의 개수 N이 주어진다.
 * 두 번째 줄에 돌의 높이 Ai (1 ≤ i ≤ N)가 서쪽부터 동쪽으로 차례로 주어진다.
 *
 * 출력형식:
 * 첫 번째 줄에 철수가 밟을 수 있는 돌의 최대 개수를 출력하라.
 *
 * 입력예제:
 * 5
 * 3 2 1 4 5
 *
 * 출력예제:
 * 3
 *
 * 출처:
 * https://www.softeer.ai/practice/info.do?idx=1&eid=390
 *
 * 참고:
 * https://k-ang.tistory.com/103
 * https://chanhuiseok.github.io/posts/algo-49/
 * https://velog.io/@jyleedev/softeer-%EC%A7%95%EA%B2%80%EB%8B%A4%EB%A6%AC-java
 *
 */
public class SteppingStone {

    // TODO: 최장증가부분수열 + DP 문제
    // 최장 증가 부분 수열(LIS, Longest Increasing Subsequence)
    // 원소가 n개인 배열의 일부 원소를 골라내서 만든 부분 수열 중에서
    // 각 원소가 이전 원소보다 크다는 조건을 만족하고, 그 길이가 최대인 부분 수열을 최장 증가 부분 수열이라고 함.
    // ex) { 6, 2, 5, 1, 7, 4, 8, 3} 이라는 배열이 있을 경우, 최장 증가 부분 수열은 { 2, 5, 7, 8 } 이 됨.

    public static int n, result;
    public static int[] stoneArr, lengthArr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        stoneArr = new int[n]; // 돌 높이 값을 저장할 배열
        lengthArr = new int[n]; // 부분 수열의 길이를 저장할 배열

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            stoneArr[i] = Integer.parseInt(st.nextToken());

            // 인덱스별 부분 수열 길이의 값은 모두 1로 초기화
            // 각 인덱스의 값은 밟을 수 있는 돌의 개수.
            lengthArr[i] = 1;
        }

        for (int i = 0; i < n; i++) {
            // i번째 까지 밞을 수 있는 돌의 최대 개수 탐색
            for (int j = 0; j < i; j++) {
                // 다음 돌이 현재 밟고 있는 돌보다 높은 경우
                if (stoneArr[j] < stoneArr[i]) {
                    // lengthArr[i] => i번째 인덱스에서 끝나는 최장 증가 부분 수열의 길이
                    // lengthArr[j] + 1 => i번째 인덱스에서 끝나는 최장 증가 부분 수열에 stoneArr[i] 값을 추가했을 때 길이
                    // lengthArr[j] + 1 이렇게 해주는건 stoneArr[j] < stoneArr[i] 조건이 성립하기 때문에 길이를 늘려주고,
                    // lengthArr[i] 값과 비교해서 최대값을 구해줌.
                    // 조건이 성립하기 때문에 밟을 수 있는 돌의 개수를 늘려주는 것.
                    lengthArr[i] = Math.max(lengthArr[i], lengthArr[j] + 1);
                }
            }
            // 밟을 수 있는 돌의 개수의 최대값을 비교하여 더 큰 값을 구함.
            result = Math.max(result, lengthArr[i]);
        }

        System.out.println(result);
    }

}
