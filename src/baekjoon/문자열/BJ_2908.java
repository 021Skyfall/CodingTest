package baekjoon.문자열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2908 {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder x = new StringBuilder(st.nextToken());
        x.reverse();
        StringBuilder y = new StringBuilder(st.nextToken());
        y.reverse();

        System.out.println(Math.max(Integer.parseInt(String.valueOf(x)), Integer.parseInt(String.valueOf(y))) );
    }
}
