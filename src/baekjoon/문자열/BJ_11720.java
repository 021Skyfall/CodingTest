package baekjoon.문자열;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_11720 {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int result = 0;
        for (int i = 0; i < n; i++) {
            result += s.charAt(i) - '0';
        }
        System.out.println(result);
    }
}
