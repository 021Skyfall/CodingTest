package baekjoon.배열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10871 {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        String nx = br.readLine();
//        String[] nxArr = nx.split(" ");
//        int n = Integer.parseInt(nxArr[0]);
//        int x = Integer.parseInt(nxArr[1]);
//
//        String nums = br.readLine();
//        String[] arr = nums.split(" ");
//
//        String result = "";
//
//        for (int i = 0; i < n; i++) {
//            if (x > Integer.parseInt(arr[i]))
//                result += arr[i] + " ";
//        }
//
//        System.out.println(result);

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int nums = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            if (a < nums) {
                sb.append(a).append(" ");
            }
        }
        System.out.println(sb);
    }
}
