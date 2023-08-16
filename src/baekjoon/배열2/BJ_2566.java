package baekjoon.배열2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2566 {
    public static void main(String[] args) throws java.io.IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = 0;
//        int[][] arr = new int[9][9];
//        while (n <9) {
//            String[] str = br.readLine().split(" ");
//            for (int i = 0; i < str.length; i++) {
//                arr[n][i] = Integer.parseInt(str[i]);
//            }
//            n++;
//        }
//
//        int max = 0;
//        int x = 0;
//        int y = 0;
//        for (int i = 0; i < 9; i++) {
//            for (int j = 0; j < arr[i].length; j++) {
//                if (arr[i][j] > max) {
//                    max = arr[i][j];
//                    x = i;
//                    y = j;
//                }
//            }
//        }
//
//        System.out.println(max + "\n" + (x+1) + " " + (y+1));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int max = 0;
        int x = 0;
        int y = 0;
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num > max) {
                    max = num;
                    x = i;
                    y = j;
                }
            }
        }

        System.out.println(max + "\n" + (x+1) + " " + (y+1));
    }
}
