import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int size : tangerine) {
            countMap.put(size, countMap.getOrDefault(size, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(countMap.entrySet());
        list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        int selected = 0;
        int typeCount = 0;
        
        for (Map.Entry<Integer, Integer> entry : list) {
            if (selected + entry.getValue() <= k) {
                selected += entry.getValue();
                typeCount++;
            } else {
                if (selected < k) {
                    typeCount++;
                }
                break;
            }
        }

        return typeCount;
    }
}