package baekjoon.배열;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_10807 {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int total = Integer.parseInt(br.readLine());

        String n = br.readLine();
        String[] arr = n.split(" ");

        int num = Integer.parseInt(br.readLine());

        int count = 0;

        br.close();

        for (int i = 0; i < total; i++) {
            if (Integer.parseInt(arr[i]) == num)
                count++;
        }

        System.out.println(count);
    }
}
