package com.freestrokes.practice.softeer.level3;

import java.util.*;
import java.util.stream.*;
import java.io.*;

/**
 * 성적 평가 (Score Evaluation)
 *
 * 난이도: 3
 *
 * 문제:
 * 현주는 N명의 인원이 참여하는 프로그래밍 스터디 그룹을 이끌고 있다.
 * 현주는 스터디를 위해 대회를 세 개 개최하였고, 모든 구성원이 각 대회에 참여하였다.
 * 참가자는 각 대회에서 0 이상 1,000 이하의 정수인 점수를 얻는다.
 * 한 대회에서 둘 이상의 참가자가 동점이 나오는 경우도 있을 수 있다.
 * 현주는 각 대회별 등수 및 최종 등수를 매기고 싶다.
 *
 * 등수는 가장 점수가 높은 사람부터 1등, 2등, ···, N등의 순서대로 붙는다.
 * 만일 동점이 있을 경우 가능한 높은 (등수의 수가 작은) 등수를 부여한다.
 *
 * 즉, 점수가 내림차순으로 10, 7, 6, 6, 4의 순서일 경우,
 * 6점을 받은 두 사람은 공동 3등이 되고, 그 다음 순서인 4점을 받은 사람은 5등이 된다.
 * 이 규칙을 다르게 표현하면 다음과 같다:
 * 각 사람마다 “나보다 점수가 큰 사람”의 수를 세어 1을 더한 것이 자신의 등수가 된다.
 *
 * 대회별 등수는 각 대회에서 얻은 점수를 기준으로 하며 최종 등수는 세 대회의 점수의 합을 기준으로 한다.
 *
 * 각 참가자의 대회별 등수 및 최종 등수를 출력하는 프로그램을 작성하시오.
 *
 * 제약조건:
 * 3 ≤ N ≤ 100,000
 *
 * 입력형식:
 * 첫째 줄에 참가자의 수를 나타내는 정수 N이 주어진다.
 * 이어 세 개의 줄에 각 대회의 결과를 나타내는 N개의 정수가 주어진다.
 * 이중 i번째 정수는 그 대회에서 i번째 사람이 얻은 점수를 의미한다.
 *
 * 출력형식:
 * 첫 세 개의 줄에는 각 참가자의 대회별 등수를 출력한다.
 * 즉 이중 c번째 줄의 i번째 정수는 c번째 대회에서의 i번째 사람의 등수를 의미한다.
 * 이어 새로운 줄에 같은 형식으로 각 참가자의 최종 등수를 출력한다.
 *
 * 입력예제:
 * CASE1)
 * 3
 * 40 80 70
 * 50 10 20
 * 100 70 30
 *
 * CASE2)
 * 3
 * 1000 1000 700
 * 300 100 400
 * 200 400 400
 *
 * 출력예제:
 * CASE1)
 * 3 1 2
 * 1 3 2
 * 1 2 3
 * 1 2 3
 *
 * CASE2)
 * 1 1 3
 * 2 3 1
 * 3 1 1
 * 1 1 1
 *
 * 출처:
 * https://www.softeer.ai/practice/info.do?idx=1&eid=1309
 *
 * 참고:
 *
 *
 */
public class ScoreEvaluation {

    // 리스트 사용해서 정렬 후 다시 풀어보기
    // 아니면 Arrays.sort() 사용해도 됨.

    public static int N, COMPETITION_COUNT = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Map<Integer, Integer>> scoreMapList = new ArrayList<>();
        Map<Integer, Integer> scoreMap;
        Map<Integer, Integer> sortedScoreMap;

        N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < COMPETITION_COUNT; i++) {
            scoreMap = new HashMap<>();
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                scoreMap.put(j, Integer.parseInt(st.nextToken()));
            }

            sortedScoreMap = scoreMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(
                    Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> { throw new AssertionError(); },
                        HashMap::new
                    )
                );

            scoreMapList.add(sortedScoreMap);
        }

        // TODO
        scoreMapList.forEach(item -> {
            for ( Integer key : item.keySet() ){
                System.out.println("key: " + key + " / value: " + item.get(key));
            }
        });

    }
}
