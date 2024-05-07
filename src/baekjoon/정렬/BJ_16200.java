package baekjoon.정렬;

import java.io.*;
import java.util.*;

public class BJ_16200 {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(arr);

        int answer = 0;
        int cnt = 0;
        int limit = 0;
        for (int i = 0; i < n; i++) {
            int cur = arr[i];
            if (cnt == 0)
                limit = cur;
            cnt++;

            if (cnt == limit) {
                cnt = 0;
                answer++;
            }
        }

        if (cnt != 0) answer++;

        System.out.println(answer);
    }
}
