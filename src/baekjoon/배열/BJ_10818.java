package baekjoon.배열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_10818 {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine());
        String n = br.readLine();
        br.close();
        String[] arr = n.split(" ");
        int[] nArr = Arrays.stream(arr).mapToInt(Integer::parseInt).toArray();
        int max = Arrays.stream(nArr).max().getAsInt();
        int min = Arrays.stream(nArr).min().getAsInt();
        System.out.println(min + " " + max);
    }
}
