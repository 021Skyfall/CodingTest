package study;

public class WordConversion {
    static boolean[] visit;
    static int answer = 0;

    public static void main(String[] args) {
        System.out.println(solution("hit","cog",new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
    }

    private static int solution(String begin, String target, String[] words) {
        visit = new boolean[words.length];
        dfs(begin, target, words, 0);
        return answer;
    }

    private static void dfs(String now, String target, String[] words, int cnt) {
        if (now.equals(target)) {
            answer = cnt;
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (visit[i])
                continue;

            int k = 0;
            for (int j = 0; j < now.length(); j++) {
                if (now.charAt(j) != words[i].charAt(j)) {
                    k++;
                }
            }

            if (k == 1) {
                visit[i] = true;
                dfs(words[i], target, words, cnt + 1);
                visit[i] = false;
            }
        }
    }
}
