import java.util.HashMap;

class Solution {
    public int solution(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);

        StringBuilder result = new StringBuilder();
        StringBuilder cur = new StringBuilder();

        for (char c : s.toCharArray()) {
            cur.append(c);

            if (map.containsKey(cur.toString())) {
                result.append(map.get(cur.toString()));
                cur.setLength(0);
            } else if (Character.isDigit(c)) {
                result.append(c);
                cur.setLength(0);
            }
        }

        return Integer.parseInt(result.toString());
    }
}