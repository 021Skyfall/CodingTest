import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) return cities.length * 5;

        int answer = 0;
        LinkedList<String> cache = new LinkedList<>();

        for (String city : cities) {
            city = city.toLowerCase();

            if (cache.remove(city)) {
                cache.addFirst(city);
                answer += 1;
            } else {
                if (cache.size() == cacheSize) {
                    cache.removeLast();
                }
                cache.addFirst(city);
                answer += 5;
            }
        }

        return answer;
    }
}