package baekjoon.심화1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_10988 {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String reverse = new StringBuilder(str).reverse().toString();

        if (str.equals(reverse)) System.out.println(1);
        else System.out.println(0);
    }
}
