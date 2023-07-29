package baekjoon.문자열;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_10809 {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        br.close();

        int[] arr = new int[26];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = -1;
        }

        for (int j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);
            if (arr[ch - 'a'] == -1)
                arr[ch - 'a'] = j;
        }

        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < arr.length; k++) {
            sb.append(arr[k]).append(" ");
        }
        System.out.println(sb);
    }
}
