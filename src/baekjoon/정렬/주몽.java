package baekjoon.정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 주몽 {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        br.readLine();
        int armor = Integer.parseInt(br.readLine());

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

        br.close();

        int startIdx = 0;
        int endIdx = arr.length - 1;
        int count = 0;
        while (startIdx < endIdx) {
            if (arr[startIdx] + arr[endIdx] > armor) {
                endIdx -= 1;
            } else if (arr[startIdx] + arr[endIdx] < armor) {
                startIdx += 1;
            } else {
                count++;
                startIdx += 1;
            }
        }

        System.out.println(count);
    }
}
