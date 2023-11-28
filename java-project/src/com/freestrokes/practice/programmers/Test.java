package com.freestrokes.practice.programmers;

import java.io.*;
import java.util.*;

public class Test {

    // NOTE: 메인 메서드 실행을 위해선 control + shift + r 또는 run 실행.
    // abcd##ef########ghij###klmn123
    // abc#ef########ghij###klmn123
    // abef########ghij###klmn123
    // abef########ghij###klmn123
    // ######ghij###klmn123
    // gklmn123

    public static int N;
    public static String keylog, data, token, removeToken;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        keylog = st.nextToken();

        getResult(keylog);

    }

    public static String getResult(String keylog) {
        data = keylog;

        if (!data.contains("#")) {
            return data;
        } else {
            for (int i = 0; i < data.length(); i++) {
                token = data.substring(i, i+1);

                if (token.equals("#")) {
                    if (i == 0) {
                        getResult(data.substring(i + 1));
                    } else {
                        removeToken = data.substring(i-1, i);
                        getResult(data.replaceFirst(removeToken, "").replaceFirst("#", ""));
                    }
                }
            }
        }

        return data;
    }

}
