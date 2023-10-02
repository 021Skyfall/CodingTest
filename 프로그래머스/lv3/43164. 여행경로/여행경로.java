import java.util.*;

class Solution {
    boolean[] visitied;
    ArrayList<String> allPath;

    public String[] solution(String[][] tickets) {
        String[] answer = {};
        int cnt = 0;
        visitied = new boolean[tickets.length];
        allPath = new ArrayList<>();

        dfs("ICN", "ICN", tickets, cnt);

        Collections.sort(allPath);
        answer = allPath.get(0).split(" ");

        return answer;
    }
    public void dfs(String start, String path, String[][] tickets, int cnt) {
        if (cnt == tickets.length) {
            allPath.add(path);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (start.equals(tickets[i][0]) && !visitied[i]) {
                visitied[i] = true;
                dfs(tickets[i][1], path + " " + tickets[i][1], tickets, cnt+1);
                visitied[i] = false;
            }
        }
    }
}