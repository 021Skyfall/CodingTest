package baekjoon.일반수학1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_11005 {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 진법 값
        int b = Integer.parseInt(st.nextToken()); // 진법
        br.close();

        List<Character> list = new ArrayList<>();

        while (n > 0) {
            if (n % b < 10) {
                list.add((char) (n % b + '0'));
            } else {
                list.add((char) (n % b - 10 + 'A'));
            }
            n /= b;
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.print(list.get(i));
        }
    }
}
