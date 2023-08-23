package baekjoon.일반수학1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_2720 {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

//        int[] coins = new int[]{25, 10, 5, 1};
//        int[] changes = new int[4];
//
//        for (int i = 0; i < n; i++) {
//            int x = Integer.parseInt(br.readLine());
//            for (int j = 0; j < coins.length; j++) {
//                changes[j] = x/coins[j];
//                x %= coins[j];
//            }
//            for (int re : changes) {
//                System.out.print(re + " ");
//            }
//        }
//        br.close();

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());

            int quarter = x / 25;
            x %= 25;

            int dime = x / 10;
            x %= 10;

            int nickel = x / 5;
            x %= 5;

            int penny = x;

            System.out.println(quarter + " " + dime + " " + nickel + " " + penny);
        }

        br.close();
    }
}
