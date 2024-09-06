import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] numbers) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            int base = numbers[i];
            for (int j = 0; j < numbers.length; j++) {
                int add = base + numbers[j];
                if (!list.contains(add) && i != j)
                    list.add(add);
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        Arrays.sort(result);
        return result;
    }
}