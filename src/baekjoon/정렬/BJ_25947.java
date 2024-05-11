package baekjoon.정렬;

import java.io.*;
import java.util.*;

public class BJ_25947 {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());

        int[] gifts = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

        int left = 0, right = n, maxGifts = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (canBuy(gifts, b, a, mid)) {
                maxGifts = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(maxGifts);
    }

    private static boolean canBuy(int[] gifts, int budget, int discount, int target) {
        long total = 0;
        for (int i = 0; i < target; i++) {
            total += gifts[i];
        }

        int discountApplied = Math.min(discount, target);
        for (int i = 0; i < discountApplied; i++) {
            total -= gifts[target - 1 - i] / 2;
        }

        return total <= budget;
    }
}