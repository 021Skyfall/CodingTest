package baekjoon.문자열;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_1152 {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!arr[i].equals(""))
                count++;
        }
        System.out.println(count);
    }
}
