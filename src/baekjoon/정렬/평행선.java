package baekjoon.정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 평행선 {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        HashMap<Integer, Integer> h = new HashMap<>();
        HashMap<Integer, Integer> v = new HashMap<>();

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            h.put(y, h.getOrDefault(y, 0) + 1);
            v.put(x, v.getOrDefault(x, 0) + 1);
        }

        int lines = 0;
        for (int count : h.values()) {
            if (count > 1) lines++;
        }
        for (int count : v.values()) {
            if (count > 1) lines++;
        }

        System.out.println(lines);
    }
}
