import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        boolean[] isO = new boolean[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            if (st.nextToken().charAt(0) == 'O') {
                isO[i] = true;
            }
        }

        int result = bfs(isO, 2 * n);
        System.out.println(result);
    }

    public static int bfs(boolean[] isO, int n) {
        int count = 0;
        Queue<boolean[]> q = new LinkedList<>();
        q.offer(isO);
        Set<String> visited = new HashSet<>();

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                boolean[] cur = q.poll();
                if (isWin(cur, n)) {
                    return count;
                }

                for (int j = 0; j < n; j++) {
                    boolean[] nxt = change(j, cur, n);
                    if (!visited.contains(Arrays.toString(nxt))) {
                        q.offer(nxt);
                        visited.add(Arrays.toString(nxt));
                    }
                }
            }

            count++;
        }

        return -1;
    }

    public static boolean[] change(int idx, boolean[] cur, int n) {
        boolean[] temp = Arrays.copyOf(cur, cur.length);
        boolean flag = cur[idx];
        for (int i = idx; i > 0; i--) {
            temp[i] = temp[i - 1];
        }

        temp[0] = flag;
        return temp;
    }

    public static boolean isWin(boolean[] cur, int n) {
        int[] score = new int[2];
        for(int i = 0 ; i < n ; i += 2){
            if(cur[i] == cur[i + 1]){
                continue;
            }
            if(cur[i]){
                score[0]++;
            }else {
                score[1]++;
            }
        }
        return score[0] > score[1];
    }
}