package baekjoon.일반수학1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2745 {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String n = st.nextToken(); // B진법의 값
        int B = Integer.parseInt(st.nextToken()); // 진법
        br.close();

        int tmp = 1;
        int result = 0;

        for (int i = n.length() - 1; i >= 0; i--) {
            char C = n.charAt(i);

            if ('A' <= C && C <= 'Z') {
                result += (C - 'A' + 10) * tmp;
            } else {
                result += (C - '0') * tmp;
            }
            tmp *= B;
        }

        System.out.println(result);
    }
}
