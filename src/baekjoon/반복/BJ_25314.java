package baekjoon.반복;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_25314 {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int bite = Integer.parseInt(br.readLine());
        br.close();

        int n = bite/4;
        StringBuilder type = new StringBuilder("long");

        type.append(" long".repeat(n - 1));
        System.out.println(type + " int");
    }
}
