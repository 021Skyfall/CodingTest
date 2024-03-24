package baekjoon.정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 일차함수 {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // 키로 정렬 * N 올림차순
        // a,b 키, 밸류
        // 중복 키에 대한 밸류 핸들링을 위해 List 사용
        Map<Long, List<Long>> map = new TreeMap<>();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());

            List<Long> values = map.getOrDefault(a, new ArrayList<>());
            values.add(b);
            map.put(a, values);
        }

        // ax + b 합산
        Long count = 0L;
        // 1 ~ n
        int i = 1;
        for (Map.Entry<Long, List<Long>> entry : map.entrySet()) {
            for (Long b : entry.getValue()) {
                count += (entry.getKey() * i) + b;
                i++;
            }
        }

        System.out.println(count);
    }
}
