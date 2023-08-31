package baekjoon.일반수학1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_1193 {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());

        int crs_count = 1, prev_count_sum = 0;

        while (true) {
            if (x <= prev_count_sum + crs_count) {
                if (crs_count % 2 == 1) {
                    System.out.println((crs_count - (x - prev_count_sum - 1)) + "/" + (x - prev_count_sum));
                    break;
                }
                else {
                    System.out.println((x - prev_count_sum) + "/" + (crs_count - (x - prev_count_sum - 1)));
                    break;
                }
            } else {
                prev_count_sum += crs_count;
                crs_count++;
            }
        }
    }
}
