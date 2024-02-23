package baekjoon.정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 접미사배열 {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String[] arr = new String[str.length()];

        arr[0] = str;

        StringBuilder sb = new StringBuilder(str);
        for (int i = 1; i < arr.length; i++) {
            arr[i] = sb.substring(i, str.length());
        }


        Arrays.sort(arr);
        for (String s : arr) {
            System.out.println(s);
        }
    }
}
