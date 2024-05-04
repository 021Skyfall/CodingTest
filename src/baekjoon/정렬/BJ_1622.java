package baekjoon.정렬;

import java.io.*;
import java.util.*;

public class BJ_1622 {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while ((line = br.readLine()) != null) {
            String a = line;
            String b = br.readLine();

            System.out.println(find(a, b));
        }
    }
    public static String find(String a, String b) {
        Map<Character, Integer> frequencyA = new HashMap<>();
        Map<Character, Integer> frequencyB = new HashMap<>();

        // 문자열 a의 각 문자 빈도수 계산
        for (char ch : a.toCharArray()) {
            frequencyA.put(ch, frequencyA.getOrDefault(ch, 0) + 1);
        }

        // 문자열 b의 각 문자 빈도수 계산
        for (char ch : b.toCharArray()) {
            frequencyB.put(ch, frequencyB.getOrDefault(ch, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        // 두 문자열에서 공통된 문자의 최소 빈도수를 기준으로 문자열 x 구성
        for (char ch : frequencyA.keySet()) {
            if (frequencyB.containsKey(ch)) {
                int minFrequency = Math.min(frequencyA.get(ch), frequencyB.get(ch));
                for (int i = 0; i < minFrequency; i++) {
                    sb.append(ch);
                }
            }
        }

        char[] characters = sb.toString().toCharArray();
        Arrays.sort(characters);

        return new String(characters);
    }
}
