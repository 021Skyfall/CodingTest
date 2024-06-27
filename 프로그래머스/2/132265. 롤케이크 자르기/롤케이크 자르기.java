import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int n = topping.length;
        if (n == 0) return 0;

        Map<Integer, Integer> leftPart = new HashMap<>();
        Map<Integer, Integer> rightPart = new HashMap<>();

        for (int t : topping) {
            rightPart.put(t, rightPart.getOrDefault(t, 0) + 1);
        }

        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            int t = topping[i];

            leftPart.put(t, leftPart.getOrDefault(t, 0) + 1);

            if (rightPart.get(t) == 1) {
                rightPart.remove(t);
            } else {
                rightPart.put(t, rightPart.get(t) - 1);
            }

            if (leftPart.size() == rightPart.size()) {
                count++;
            }
        }

        return count;
    }
}