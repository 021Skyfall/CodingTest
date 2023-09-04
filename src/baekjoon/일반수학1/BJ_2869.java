package baekjoon.일반수학1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2869 {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

//        int result = 0;
//        int count = 0;
//
//        while (result < v) {
//            result += a;
//            result -= b;
//            count++;
//        }
//
//        count -= b;
//        System.out.println(count);

        int count = (v - b) / (a - b);
        if ((v - b) % (a - b) != 0) {
            count++;
        }
        System.out.println(count);
    }
}
