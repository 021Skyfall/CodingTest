package baekjoon.반복;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class AB_3 {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>(n);

//        for (int i = 1; i <= n; i++) {
//            String plus = br.readLine();
//            String[] result = plus.split(" ");
//            int a = Integer.parseInt(result[0]);
//            int b = Integer.parseInt(result[1]);
//            list.add(a+b);
//        }
//        for (int i = 0; i < n; i++) {
//            System.out.println(list.get(i));
//        }

        for (int i = 0; i < n; i++) {
            String plus = br.readLine();
            String[] result = plus.split(" ");
            int a = Integer.parseInt(result[0]);
            int b = Integer.parseInt(result[1]);
            System.out.println(a + b);
        }
    }
}
