package com.freestrokes.practice.softeer.level2;

import java.util.*;
import java.io.*;

/**
 * 키로거 (Keylogger)
 * - 2023 하반기 KEP 연계 채용 코딩 테스트 출제
 *
 * 난이도: 2
 *
 * 문제:
 *
 *
 * 제약조건:
 * 1 ≤ N ≤ 100인 정수
 *
 * 입력형식:
 * 첫 번째 줄에 길이 N이 주어지고, 두 번째 줄에 키로그 정보가 주어진다.
 *
 * 출력형식:
 * 주어진 문자열에 대해 Backspace 문자('#')를 삭제 연산한 결과를 출력한다.
 *
 * 입력예제:
 * CASE1)
 * 10
 * abcd##efgh
 *
 * CASE2)
 * 30
 * abcd##ef########ghij###klmn123
 *
 * 출력예제:
 * CASE1)
 * abefgh
 *
 * CASE2)
 * gklmn123
 *
 * 출처:
 *
 *
 * 참고:
 *
 *
 */
public class Keylogger {

    public static int N;
    public static String data, str, beforeStr, token, removeToken, keylog;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        data = st.nextToken();

        System.out.println(getResult1(data));
        System.out.println(getResult2(data));
        System.out.println(getResult3(data));
    }

    // Solution1
    public static String getResult1(String keylog) {
        data = keylog;

        if (!data.contains("#")) {
            return data;
        } else {
            for (int i = 0; i < data.length(); i++) {
                token = data.substring(i, i+1);

                if (token.equals("#")) {
                    if (i == 0) {
                        getResult1(data.substring(i + 1));
                    } else {
                        removeToken = data.substring(i-1, i);
                        getResult1(data.replaceFirst(removeToken, "").replaceFirst("#", ""));
                    }
                }
            }
        }

        return data;
    }

    // Solution2
    public static String getResult2(String data) {
        for (int i = 0; i < data.length(); i++) {
            str = data.substring(i, i+1);

            if ("#".equals(str)) {
                if (i == 0) {
                    data = getResult2(data.substring(i+1));
                } else {
                    beforeStr = data.substring(i-1, i);
                    data = getResult2(data.replaceFirst(beforeStr, "").replaceFirst(str, ""));
                }
            }
        }
        return data;
    }

    // Solution3
    public static String getResult3(String keylog) {
        String resultStr = keylog;

        if (resultStr.contains("#")) {
            String removeStr = "#";
            if (resultStr.indexOf("#") > 0) {
                removeStr = resultStr.substring(resultStr.indexOf("#") - 1, resultStr.indexOf("#") + 1);
            }
            resultStr = getResult3(resultStr.replaceFirst(removeStr, ""));
        }

        return resultStr;
    }
}


