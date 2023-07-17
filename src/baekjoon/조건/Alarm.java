package baekjoon.조건;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Alarm {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String time = br.readLine();
        String[] result = time.split(" ");
        int h = Integer.parseInt(result[0]);
        int m = Integer.parseInt(result[1]);
        if (m < 45) {
            if (h == 0) h = 23;
            else h--;
            m += 15;
        } else {
            m -= 45;
        }
        if (m == 60)
            m = 0;
        System.out.println(h + " " + m);
    }
}
