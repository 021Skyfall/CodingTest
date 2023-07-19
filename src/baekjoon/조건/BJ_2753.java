package baekjoon.조건;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_2753 {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int year = Integer.parseInt(br.readLine());

        if (year % 4 == 0 & year % 100 != 0 | year % 400 == 0)
            System.out.println(1);
        else System.out.println(0);

        br.close();
    }

    // 충격! & 연산자 && 도 되고 & 도 됨 !!
}
