package baekjoon.정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 카드 {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        HashMap<Long, Integer> map = new HashMap<>();
        while (n-- > 0) {
            long card = Long.parseLong(br.readLine());
            if (map.containsKey(card)) {
                map.put(card, map.get(card) + 1);
            } else {
                map.put(card, 1);
            }
        }

        int max = Collections.max(map.values());

        ArrayList<Long> maxCard = new ArrayList<>();
        for (Map.Entry<Long, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                maxCard.add(entry.getKey());
            }
        }

        Collections.sort(maxCard);

        System.out.println(maxCard.get(0));
    }
}
