package baekjoon.심화1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_2941 {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int len = str.length();
        int count = 0;

        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);

            if (ch == 'c' && i < len - 1) {
                if (str.charAt(i + 1) == '=' || str.charAt(i + 1) == '-') {
                    i++; // i + 1까지가 하나의 문자이므로 건너뜀
                }
            } else if (ch == 'd' && i < len - 1) {
                if (str.charAt(i + 1) == '-') { // d- 일 경우
                    i++;
                } else if (str.charAt(i + 1) == 'z' && i < len - 2) {
                    if (str.charAt(i + 2) == '=') { // dz= 일 경우
                        i += 2;
                    }
                }
            } else if ((ch == 'l' || ch == 'n') && i < len - 1) {
                if (str.charAt(i + 1) == 'j') { // lj 또는 nj일 경우
                    i++;
                }
            } else if ((ch == 's' || ch == 'z') && i < len - 1) {
                if (str.charAt(i + 1) == '=') {
                    i++;
                }
            }
            count++;
        }
        System.out.println(count);
    }
}
