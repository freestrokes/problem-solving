package com.freestrokes.practice.softeer.level3;

import java.util.*;
import java.io.*;

/**
 * 성적 평균 (Score Average)
 *
 * 난이도: 3
 *
 * 문제:
 * N명의 학생들의 성적이 학번순서대로 주어졌다.
 * 학번 구간 [A, B]가 주어졌을 때 이 학생들 성적의 평균을 구하는 프로그램을 작성하라.
 *
 * 제약조건:
 * 1 ≤ N ≤ 106 인 정수
 * 1 ≤ K ≤ 104 인 정수
 * 1 ≤ Si ≤ 100 인 정수
 * 1 ≤ Ai ≤ Bi ≤ N
 *
 * 입력형식:
 * 첫 번째 줄에 학생 수 N과 구간 수 K가 주어진다.
 * 두 번째 줄에는 학생의 성적 Si (1 ≤ i ≤ N)가 주어진다.
 * i + 2 (1 ≤ i ≤ K)번째 줄에는 i번째 구간 Ai, Bi가 주어진다.
 *
 * 출력형식:
 * i번째 줄에 i번째 구간의 성적평균(소수셋째자리에서 반올림)을 출력한다.
 * 차이가 0.01이하이면 정답으로 채점됨.
 *
 * 입력예제:
 * 5 3
 * 10 50 20 70 100
 * 1 3
 * 3 4
 * 1 5
 *
 * 출력예제:
 * 26.67
 * 45.00
 * 50.00
 *
 * 출처:
 * https://www.softeer.ai/practice/info.do?idx=1&eid=389
 *
 * 참고:
 * https://velog.io/@jyleedev/softeer-java-%EC%84%B1%EC%A0%81-%ED%8F%89%EA%B7%A0
 * https://january-diary.tistory.com/entry/Softeer-%EC%84%B1%EC%A0%81-%ED%8F%89%EA%B7%A0-JAVA
 *
 */
public class ScoreAverage {

    // TODO: Math 클래스 메서드
    // Math.round() -> 반올림
    // Math.ceil() -> 올림
    // Math.floor() -> 내림
    // Math.abs() -> 절대값

    public static int n, k, a, b, interval;
    public static double sum;
    public static int[] scoreArr, intervalArr;
    public static double[] sumArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 학생 수
        k = Integer.parseInt(st.nextToken()); // 구간 수
        scoreArr = new int[n];
        intervalArr = new int[k];
        sumArr = new double[k];

        st = new StringTokenizer(br.readLine());

        // 학생 수에 따른 성적 입력
        for (int i = 0; i < n; i++) {
            scoreArr[i] = Integer.parseInt(st.nextToken());
        }

        // 구간에 따른 성적 입력
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            interval = b - a + 1;
            sum = 0.00D;

            for (int j = a-1; j < b; j++) {
                sum += scoreArr[j];
            }

            sumArr[i] = sum;
            intervalArr[i] = interval;
        }

        // 성적 평균 출력
        for (int i = 0; i < k; i++) {
            // printf 사용하여 자릿수 출력.
            System.out.printf("%.2f\n", sumArr[i] / intervalArr[i]);

            // TODO: 아래와 같이 String.format() 사용해도 됨.
//            String result = String.format("%.2f", sumArr[i] / intervalArr[i]);
//            System.out.println(result);
        }
    }
}
