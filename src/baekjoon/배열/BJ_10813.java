package baekjoon.배열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10813 {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] basket = new int[N];
        for (int k = 0; k < basket.length; k++) {
            basket[k] = k+1;
        }

        for (int l = 0; l < M; l++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int temp = basket[i-1];
            basket[i-1] = basket[j-1];
            basket[j-1] = temp;
        }
        br.close();

        StringBuilder result = new StringBuilder();
        for (int m = 0; m < N; m++) {

            result.append(basket[m]).append(" ");
        }
        System.out.println(result);
    }
}
