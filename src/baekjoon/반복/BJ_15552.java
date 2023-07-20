package baekjoon.반복;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_15552 {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int result = a + b;
            bw.write(result+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

// 시간초과
//public class BJ_15552 {
//    public static void main(String[] args) throws java.io.IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        List<Integer> list = new ArrayList<>();
//
//        for (int i = 0; i < n; i++) {
//            String s = br.readLine();
//            StringTokenizer st = new StringTokenizer(s);
//            int a = Integer.parseInt(st.nextToken());
//            int b = Integer.parseInt(st.nextToken());
//            list.add(a+b);
//        }
//        for (int i = 0; i < n; i++) {
//            System.out.println(list.get(i));
//        }
//    }
//}
