package baekjoon.반복;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class gugudan {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i < 10; i++) {
            System.out.println(n + " * " + i + " = " + n*i);
        }
    }
}
