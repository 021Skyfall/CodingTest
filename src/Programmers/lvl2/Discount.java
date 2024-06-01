package Programmers.lvl2;

import java.util.HashMap;
import java.util.Map;

public class Discount {
    public static void main(String[] args) throws java.io.IOException {

        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {
                "chicken", "apple", "apple", "banana", "rice", "apple", "pork",
                "banana", "pork", "rice", "pot", "banana", "apple", "banana"
        };

        System.out.println(solution(want, number, discount));
    }

    public static int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int n = discount.length;
        int period = 10;

        Map<String, Integer> wantMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }

        for (int i = 0; i <= n - period; i++) {
            Map<String, Integer> discountMap = new HashMap<>();
            for (int j = i; j < i + period; j++) {
                discountMap.put(discount[j], discountMap.getOrDefault(discount[j], 0) + 1);
            }

            boolean match = true;
            for (String item : wantMap.keySet()) {
                if (discountMap.getOrDefault(item, 0) < wantMap.get(item)) {
                    match = false;
                    break;
                }
            }

            if (match) {
                answer++;
            }
        }

        return answer;
    }
}