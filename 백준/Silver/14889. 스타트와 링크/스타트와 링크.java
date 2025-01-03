import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static boolean[] team = new boolean[20];
    static int[][] score = new int[20][20];
    static int N, min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                score[i][j] = scanner.nextInt();
            }
        }

        teamset(0, 0);
        System.out.println(min);
        scanner.close();
    }

    static void teamset(int idx, int cnt) {
        List<Integer> start = new ArrayList<>();
        List<Integer> link = new ArrayList<>();
        int start_score = 0;
        int link_score = 0;

        if (cnt == (N / 2)) {
            for (int i = 0; i < N; i++) {
                if (team[i])
                    start.add(i);
                else
                    link.add(i);
            }

            for (int i = 0; i < (N / 2); i++) {
                for (int j = 0; j < (N / 2); j++) {
                    start_score += score[start.get(i)][start.get(j)];
                    link_score += score[link.get(i)][link.get(j)];
                }
            }

            if (Math.abs(start_score - link_score) < min)
                min = Math.abs(start_score - link_score);
            return;
        }

        for (int i = idx; i < N; i++) {
            if (team[i])
                continue;
            else {
                team[i] = true;
                teamset(i, cnt + 1);
                team[i] = false;
            }
        }
    }
}