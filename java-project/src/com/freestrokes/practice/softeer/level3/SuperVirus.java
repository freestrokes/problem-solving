package com.freestrokes.practice.softeer.level3;

import java.util.*;
import java.io.*;

/**
 * 수퍼 바이러스 (Super Virus)
 *
 * 난이도: 3
 *
 * 문제:
 * 수퍼바이러스가 숙주의 몸속에서 0.1초당 P배씩 증가한다.
 * 처음에 수퍼바이러스 K마리가 있었다면 N초 후에는 총 몇 마리의 수퍼바이러스로 불어날까?
 * N초 동안 죽는 수퍼바이러스는 없다고 가정한다.
 * 수퍼바이러스는 일반 바이러스에 비해서 훨씬 오래 생존할 수 있기 때문에 N이 매우 클 수 있다.
 *
 * 제약조건:
 * 1 ≤ K ≤ 10^8인 정수
 * 1 ≤ P ≤ 10^8인 정수
 * 1 ≤ N ≤ 10^16인 정수
 *
 * 입력형식:
 * 첫 번째 줄에 처음 바이러스의 수 K, 증가율 P, 총 시간 N(초)이 주어진다.
 *
 * 출력형식:
 * 최종 바이러스 개수를 1000000007로 나눈 나머지를 출력한다.
 *
 * 입력예제:
 * 1 2 1
 *
 * 출력예제:
 * 1024
 *
 * 출처:
 * https://www.softeer.ai/practice/info.do?idx=1&eid=391
 *
 * 참고:
 * https://whatryando.tistory.com/11
 *
 */
public class SuperVirus {

    // TODO: 런타임 에러와 시간초과 에러 발생하는 부분 확인 필요.

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken()); // 바이러스의 수
        int p = Integer.parseInt(st.nextToken()); // 증가율
        int n = Integer.parseInt(st.nextToken()) * 10; // 시간 (초)
        long result = k;

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
