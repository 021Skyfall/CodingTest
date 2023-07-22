package baekjoon.반복;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_10951 {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String nums = br.readLine();

            if (nums == null)
                break;

            String[] arr = nums.split(" ");
            int a = Integer.parseInt(arr[0]);
            int b = Integer.parseInt(arr[1]);

            System.out.println(a + b);
        }
    }
}
