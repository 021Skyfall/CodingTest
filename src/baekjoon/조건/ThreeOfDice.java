package baekjoon.조건;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ThreeOfDice {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String dice = br.readLine();
        String[] nums = dice.split(" ");
        int a = Integer.parseInt(nums[0]);
        int b = Integer.parseInt(nums[1]);
        int c = Integer.parseInt(nums[2]);

        if (a == b & a == c)
            System.out.println(10000 + a * 1000);
        else if (a == b || a == c || b == c) {
            if (a == b || a == c) System.out.println(1000 + a * 100);
            else System.out.println(1000 + b * 100);
        }
        else {
            System.out.println(100 * Math.max(a,Math.max(b,c)));
        }
    }
}
