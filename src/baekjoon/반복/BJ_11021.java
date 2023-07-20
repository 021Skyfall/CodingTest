package baekjoon.반복;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_11021 {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            String numbers = br.readLine();
            String[] count = numbers.split(" ");
            int a = Integer.parseInt(count[0]);
            int b = Integer.parseInt(count[1]);

            System.out.println("Case #"+i+": " + (a+b));
        }

        br.close();
    }
}
