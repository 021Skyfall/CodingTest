package baekjoon.심화1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_25206 {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String str = "";
//        double grade = 0.0;
//        double count = 0;
//        double total = 0.0;
//
//        while ((str = br.readLine()) != null) {
//            String[] arr = str.split(" ");
//            double standard = 0;
//            switch (arr[2]) {
//                case "A+":
//                    standard = 4.5;
//                    break;
//                case "A0":
//                    standard = 4.0;
//                    break;
//                case "B+":
//                    standard = 3.5;
//                    break;
//                case "B0":
//                    standard = 3.0;
//                    break;
//                case "C+":
//                    standard = 2.5;
//                    break;
//                case "C0":
//                    standard = 2.0;
//                    break;
//                case "D+":
//                    standard = 1.5;
//                    break;
//                case "D0":
//                    standard = 1.0;
//                    break;
//                case "P":
//                    arr[1] = "0";
//                    break;
//                default:
//                    standard = 0.0;
//                    break;
//            }
//
//            count += Double.parseDouble(arr[1]);
//            grade += Double.parseDouble(arr[1]) * standard;
//        }
//        br.close();
//
//        total = grade / count;
//        System.out.println(total);

        StringTokenizer st;

        String score[] = {"A+", "A0", "B+", "B0", "C+", "C0", "D+", "D0", "F"};
        float sum = 0;
        float count = 0;

        for(int i=0; i<20; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String sub = st.nextToken();
            float point = Float.parseFloat(st.nextToken());
            String grade = st.nextToken();

            if(grade.equals("P"))
                continue;
            else if(grade.equals("F")) {
                sum += 0;
                count += point;
            }
            else {
                sum += (4.5 - Arrays.asList(score).indexOf(grade) * 0.5) * point;
                count += point;
            }
        }
        System.out.println(sum/count);
        br.close();

    }
}
