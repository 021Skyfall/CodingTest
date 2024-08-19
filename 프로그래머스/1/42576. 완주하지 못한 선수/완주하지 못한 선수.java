import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();

        // 참가자 수를 해시맵에 저장
        for (String name : participant) {
            map.put(name, map.getOrDefault(name, 0) + 1);
        }

        // 완주자 수를 해시맵에서 감소
        for (String name : completion) {
            map.put(name, map.get(name) - 1);
        }

        // 완주하지 못한 선수 찾기
        for (String name : map.keySet()) {
            if (map.get(name) > 0) {
                return name;
            }
        }

        return "";
    }
}