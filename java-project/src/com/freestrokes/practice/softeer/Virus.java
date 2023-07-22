package com.freestrokes.practice.softeer;

import java.util.*;
import java.io.*;

/**
 * 바이러스 (Virus)
 *
 * 문제:
 * 바이러스가 숙주의 몸속에서 1초당 P배씩 증가한다.
 * 처음에 바이러스 K마리가 있었다면 N초 후에는 총 몇 마리의 바이러스로 불어날까? N초 동안 죽는 바이러스는 없다고 가정한다.
 *
 * 제약조건:
 * 1 ≤ K ≤ 10^8인 정수
 * 1 ≤ P ≤ 10^8인 정수
 * 1 ≤ N ≤ 10^6인 정수
 *
 * 입력형식:
 * 첫 번째 줄에 처음 바이러스의 수 K, 증가율 P, 총 시간 N(초)이 주어진다.
 *
 * 출력형식:
 * 최종 바이러스 개수를 1000000007로 나눈 나머지를 출력하라.
 *
 * 입력예제:
 * 2 3 2
 *
 * 출력예제:
 * 18
 *
 * 출처:
 * https://softeer.ai/practice/info.do?idx=1&eid=407
 *
 * 참고:
 * https://serendev.tistory.com/143
 * https://void2017.tistory.com/360
 * https://whatryando.tistory.com/11
 *
 */
public class Virus {

    public static int k, p, n;
    public static long result;

    public static void main(String[] args) throws IOException {

        // BufferedReaderd와 Scanner의 입력 속도를 비교해보면 BufferedReader가 더 빠르게 동작한다.
        // 적은 양의 데이터인 경우엔 문제가 없겠지만 데이터 양이 많아질수록 성능 차이는 크게 나타난다.
        // BufferedReader가 버퍼에 입력값을 버퍼에 저장했다가 전송하기 때문에 더 빠르다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        k = Integer.parseInt(st.nextToken()); // 바이러스의 수
        p = Integer.parseInt(st.nextToken()); // 증가율
        n = Integer.parseInt(st.nextToken()); // 시간 (초)
        result = k;

        // TODO: CASE1)
        // for문을 사용한 반복.
//        for(int i = 1; i <= n; i++) {
//            result = (result * p) % 1000000007;
//        }

        // TODO: CASE2)
        // 재귀함수를 이용한 분할정복 사용.
        result = virusCalc(k, p, n);
        System.out.println(result);

    }

    public static long virusCalc(long k, int p, int n) {
        if (n == 0) {
            return k;
        } else {
            // 모듈러(Modular) 연산을 사용.
            // 연산 결과를 계속 1000000007로 나누어 줌.
            // 최종적으로 출력할 값은 연산 결과를 1000000007롤 나눈 나머지 값이기 때문에
            // 계속 1000000007로 나누어서 나머지 값을 반환해줌.
            // 모듈러 연산 예시 -> (a * b) % M = ( (a % M) * (b % M) ) % M
            k = (k * p) % 1000000007;
            n--;
            return virusCalc(k, p, n);
        }
    }

}
