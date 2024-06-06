package Programmers.lvl2.hash;

import java.util.HashMap;

public class Outfits {
    public static void main(String[] args) {
        String[][] clothes = {
                {"yellowhat", "headgear"},
                {"bluesunglasses", "eyewear"},
                {"green_turban", "headgear"}
        };
        System.out.println(solution(clothes));
    }

    public static int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String[] cloth : clothes) {
            String type = cloth[1];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }

        int answer = 1;

        for (int count : map.values()) {
            answer *= (count + 1);
        }

        return answer - 1;
    }
}
