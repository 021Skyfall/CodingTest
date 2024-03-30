package baekjoon.정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 빈도정렬 {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // 숫자의 등장 순서를 추적하기 위한 LinkedHashMap
        Map<Integer, Integer> freqMap = new LinkedHashMap<>();
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // 빈도수에 따라 정렬할 리스트 생성 (단, 입력 순서를 유지)
        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(freqMap.entrySet());

        // 입력 배열을 순회하며 숫자의 초기 등장 순서를 기록
        List<Integer> order = new ArrayList<>();
        for (int num : arr) {
            if (!order.contains(num)) {
                order.add(num);
            }
        }

        // 빈도수에 따라 내림차순 정렬하되, 빈도수가 같으면 초기 등장 순서대로 정렬
        entries.sort((entry1, entry2) -> {
            int freqCompare = entry2.getValue().compareTo(entry1.getValue());
            if (freqCompare == 0) { // 빈도수가 같으면
                return Integer.compare(order.indexOf(entry1.getKey()), order.indexOf(entry2.getKey()));
            }
            return freqCompare;
        });

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, Integer> entry : entries) {
            for (int i = 0; i < entry.getValue(); i++) {
                sb.append(entry.getKey()).append(" ");
            }
        }

        System.out.println(sb.toString().trim());
    }
}