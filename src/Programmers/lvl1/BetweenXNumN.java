package Programmers.lvl1;

import java.util.Arrays;

public class BetweenXNumN {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(2, 5)));
    }

    public static long[] solution(int x, int n) {
        long[] arr = new long[n];
        arr[0] = x;

        for (int i = 1; i < n; i++){
            arr[i] = x + arr[i - 1];
        }

        return arr;
    }
}
