package baekjoon.문자열;

import java.io.*;

public class sodduck {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int sCount = 0, tCount = 0;

        for (char c : s.toCharArray()) {
            if (c == 's') sCount++;
            else if (c == 't') tCount++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (sCount == tCount && (sCount > 0 || tCount > 0)) {
                bw.write(s.substring(i) + "\n");
                break;
            }
            if (s.charAt(i) == 's') sCount--;
            else if (s.charAt(i) == 't') tCount--;
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
