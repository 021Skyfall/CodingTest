class Solution {
    private static final char[] VOWELS = {'A', 'E', 'I', 'O', 'U'};
    private static int count = 0;
    private static int result = 0;

    public int solution(String word) {
        dfs("", word);
        return result;
    }

    private void dfs(String current, String target) {
        if (current.equals(target)) {
            result = count;
            return;
        }

        if (current.length() >= 5) {
            return;
        }

        for (char c : VOWELS) {
            count++;
            dfs(current + c, target);
        }
    }
}