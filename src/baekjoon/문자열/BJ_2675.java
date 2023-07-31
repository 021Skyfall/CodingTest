package baekjoon.문자열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2675 {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n  = Integer.parseInt(br.readLine());


        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); // -> 3

            StringBuilder sb = new StringBuilder();
            String[] arr = st.nextToken().split("");
            int l = arr.length;
            for (String s : arr) {
                sb.append(s.repeat(x));
            }
            System.out.println(sb);
        }

//        for (int i = 0; i < n; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            int x = Integer.parseInt(st.nextToken());
//            String str = st.nextToken();
//
//            for (int j = 0; j < str.length(); j++) {
//                for (int k = 0; k < x; k++) {
//                    System.out.print(str.charAt(j));
//                }
//            }
//            System.out.println();
//        }
    }
}
