import java.util.HashMap;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        HashMap<Character, Integer> map = new HashMap<>();

        // 모든 인덱스를 -1로 초기화
        for (int i = 0; i < answer.length; i++) {
            answer[i] = -1;
        }

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (map.containsKey(currentChar)) {
                answer[i] = i - map.get(currentChar);
            }
            map.put(currentChar, i);
        }

        return answer;
    }
}