package baekjoon.정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 베스트셀러 {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String book = br.readLine();
            if (map.containsKey(book)) {
                map.put(book, map.get(book) + 1);
            } else {
                map.put(book, 1);
            }
        }

        int max = Collections.max(map.values());

        ArrayList<String> best = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                best.add(entry.getKey());
            }
        }

        Collections.sort(best);

        System.out.println(best.get(0));
    }
}
