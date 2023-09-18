import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int solution(String[] user_id, String[] banned_id) {
        Set<Set<String>> validCombinations = new HashSet<>();
        generateValidCombinations(user_id, banned_id, 0, new HashSet<>(), validCombinations);
        return validCombinations.size();
    }

    public void generateValidCombinations(String[] user_id, String[] banned_id, int index, Set<String> currentCombination, Set<Set<String>> validCombinations) {
        if (index == banned_id.length) {
            if (currentCombination.size() == banned_id.length) {
                validCombinations.add(new HashSet<>(currentCombination));
            }
            return;
        }

        String currentBannedId = banned_id[index];
        for (String userId : user_id) {
            if (!currentCombination.contains(userId) && IdLength(userId, currentBannedId) && compare(userId, currentBannedId)) {
                currentCombination.add(userId);
                generateValidCombinations(user_id, banned_id, index + 1, currentCombination, validCombinations);
                currentCombination.remove(userId);
            }
        }
    }

    public boolean compare(String x, String y) {
        int count = 0;
        int leng = 0;
        for (int i = 0; i < x.length(); i++) {
            if (x.charAt(i) == y.charAt(i)) {
                count++;
            }
        }
        for (int i = 0; i < y.length(); i++) {
            if (y.charAt(i) != '*')
                leng++;
        }
        return count == leng;
    }

    private static boolean IdLength(String x, String y) {
        return x.length() == y.length();
    }
}