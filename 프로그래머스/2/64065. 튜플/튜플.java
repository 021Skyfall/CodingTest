import java.util.*;

class Solution {
    public int[] solution(String s) {
        Map<String, Integer> map = new HashMap<>();
        String[] arr = s.replaceAll("[{}]", " ").trim().split(" , ");
        
        for (String a : arr) {
            String[] nums = a.split(",");
            for (String num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }

        List<Map.Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
        entries.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        int[] answer = new int[map.size()];
        int idx = 0;
        for (Map.Entry<String, Integer> entry : entries) {
            answer[idx++] = Integer.parseInt(entry.getKey());
        }

        return answer;
    }
}