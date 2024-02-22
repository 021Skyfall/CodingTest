package baekjoon.정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 삼십 {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer[] n = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
        Arrays.sort(n, Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for (Integer integer : n) {
            sb.append(integer);
        }

        String result = sb.toString();

        int sum = 0;
        for (char c : result.toCharArray()) {
            sum += c - '0';
        }

        if (sum % 3 == 0 && result.contains("0")) {
            System.out.println(result);
        } else System.out.println(-1);
    }
}
