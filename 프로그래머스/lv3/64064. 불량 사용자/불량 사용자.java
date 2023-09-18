import java.util.*;

public class Solution {
    public int solution(String[] user_id, String[] banned_id) {
        Set<Set<String>> validComb = new HashSet<>();
        findValidCombinations(user_id, banned_id, 0, new HashSet<>(), validComb);
        return validComb.size();
    }

    public void findValidCombinations(String[] user_id, String[] banned_id, int index, Set<String> curComb, Set<Set<String>> validComb) {
        if (index == banned_id.length) {
            validComb.add(new HashSet<>(curComb));
            return;
        }

        String currentBannedId = banned_id[index];
        for (String userId : user_id) {
            if (!curComb.contains(userId) && isValid(userId, currentBannedId)) {
                curComb.add(userId);
                findValidCombinations(user_id, banned_id, index + 1, curComb, validComb);
                curComb.remove(userId);
            }
        }
    }

    public boolean isValid(String user, String banned) {
        if (user.length() != banned.length()) {
            return false;
        }

        for (int i = 0; i < user.length(); i++) {
            if (banned.charAt(i) != '*' && banned.charAt(i) != user.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}