package baekjoon.정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 대표자연수 {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, Collections.reverseOrder());

        int repNum = 0;
        int resultSum = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int target = arr[i];
            int sum = 0;

            for (Integer integer : arr) {
                sum += Math.abs(target - integer);
            }

            if (resultSum > sum || (resultSum == sum && target < repNum)) {
                repNum = target;
                resultSum = sum;
            }
        }

        System.out.println(repNum);
    }
}
