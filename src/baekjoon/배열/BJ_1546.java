package baekjoon.배열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1546 {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine());

//        double[] scores = Arrays.stream(br.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
//
//        double m = Arrays.stream(scores).max().getAsDouble();
//        for (int i = 0; i < scores.length; i++) {
//            scores[i] = scores[i]/m * 100;
//        }
//        System.out.println(Arrays.stream(scores).average().orElseThrow());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = 0;
        double sum = 0;

        for (int i = 0; i < total; i++) {
            int score = Integer.parseInt(st.nextToken());
            if (score > m) {
                m = score;
            }
            sum += score;
        }

        System.out.println(sum / m * 100 / total);
    }
}
