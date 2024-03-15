package baekjoon.정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 화살표그리기 {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 점의 개수
        int n = Integer.parseInt(br.readLine());

        // 색깔별로 점을 저장
        ArrayList<Integer>[] points = new ArrayList[5001];
        for (int i = 0; i <= 5000; i++) {
            points[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int pos = Integer.parseInt(st.nextToken()); // 점 위치
            int color = Integer.parseInt(st.nextToken()); // 점 색깔
            points[color].add(pos); // 같은 색깔의 점 그룹핑
        }

        int answer = 0; // 화살표의 총 길이 저장

        for (int i = 0; i <= 5000; i++) {
            // 각 색별로 정렬, 인접한 점들의 최소 거리 계산
            Collections.sort(points[i]);
            for (int j = 0; j < points[i].size(); j++) {
                if (j == 0) { // 첫 번째 점은 다음 점과의 거리만 계산
                    answer += points[i].get(j + 1) - points[i].get(j);
                } else if (j == points[i].size() - 1) { // 마지막 점은 이전 점과의 거리만 계산
                    answer += points[i].get(j) - points[i].get(j - 1);
                } else { // 중간 점은 양쪽 점과의 거리 중 더 짧은 거리 계산
                    answer += Math.min(points[i].get(j) - points[i].get(j - 1), points[i].get(j + 1) - points[i].get(j));
                }
            }
        }

        System.out.println(answer);
    }
}
