package baekjoon.조건;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_2525 {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String now = br.readLine();
        String[] time = now.split(" ");
        int h = Integer.parseInt(time[0]);
        int m = Integer.parseInt(time[1]);
        int timer = Integer.parseInt(br.readLine());

//        h += timer / 60;
//        m += timer % 60;
//        if (m >= 60) {
//            h ++;
//            m -= 60;
//        }
//        if (h >= 24) h -= 24;

        // 시간 계산법
        h = (h+ (m+timer) / 60) % 24;
        m = (m+timer)%60;
        System.out.println(h + " " + m);
    }
}
