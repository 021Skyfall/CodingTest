package baekjoon.문자열;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_27866 {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        int i = Integer.parseInt(br.readLine());

        System.out.println(S.charAt(i-1));
    }
}
