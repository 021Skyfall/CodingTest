package baekjoon.배열;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_10810 {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] total = br.readLine().split(" ");
        int[] basket = new int[Integer.parseInt(total[0])];
        int count = Integer.parseInt(total[1]);

        for (int i = 0; i < count; i++) {
            String[] nums = br.readLine().split(" ");
            int ball = Integer.parseInt(nums[2]);

            for (int j = Integer.parseInt(nums[0]) - 1; j < Integer.parseInt(nums[1]); j++) {
                basket[j] = ball;
            }
        }

        br.close();

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < basket.length; i++) {

            result.append(basket[i]).append(" ");
        }
        System.out.println(result);
    }
}

/*
m 개의 바구니가 있을 때
n 번 공을 넣을 것이고
각 공에는 번호가 있으며
모든 바구니에는 공이 하나만 들어 갈 수 있다.
출력은 공의 번호를.
 */