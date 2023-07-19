package baekjoon.조건;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_14681 {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());

        if (a*b > 0) {
            if (a > 0) System.out.println(1);
            else System.out.println(3);
        } else if (a*b < 0) {
            if (a > 0) System.out.println(4);
            else System.out.println(2);
        }
    }
}
