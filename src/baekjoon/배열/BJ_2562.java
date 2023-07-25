package baekjoon.배열;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_2562 {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = 0;
        int count = 0;

        for (int i = 0; i < 9; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n > x) {
                x = n;
                count = i+1;
            }
        }

        br.close();
        System.out.println(x + "\n" + count);
    }
}
