package study;

import java.util.Arrays;

public class BestSet {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(2, 9)));
        System.out.println(Arrays.toString(solution(2, 1)));
        System.out.println(Arrays.toString(solution(2, 8)));
    }
    private static int[] solution(int n, int s) {
        if (n > s) return new int[]{-1};

        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            answer[i] = s/n;
        }

        for (int i = 0; i < s%n; i++) {
            answer[i]++;
        }

        Arrays.sort(answer);

        return answer;
    }
}
