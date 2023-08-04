package baekjoon.심화1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_1157 {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String str = br.readLine().toUpperCase();

        // 1 - X
//        int count = 0;
//        String result = "";
//        for (int i = 0; i < str.length(); i++) {
//            char ch = str.charAt(i);
//            for (int j = 1; j < str.length(); j++) {
//                if (ch == str.charAt(j))
//                    count++;
//                if (count > 1) {
//                    count = 0;
//                    result = String.valueOf(str.charAt(i));
//                    break;
//                }
//            }
//            System.out.println(result);
//        }

        // 2 - 288ms
//        int[] arr = new int[26];
//        for (int i = 0; i < str.length(); i++) {
//            arr[str.charAt(i) - 'A']++;
//        }
//        int max = 0;
//        char ch = '?';
//
//        for (int i = 0; i < 26; i++) {
//            if (arr[i] > max) {
//                max = arr[i];
//                ch = (char) (i+65);
//            }
//            else if (arr[i] == max) {
//                ch = '?';
//            }
//        }
//        System.out.println(ch);

        // 3 - 152ms
        int[] arr = new int[26];
        int c = System.in.read();

        while(c > 64) {
            if (c < 91) {
                arr[c - 65]++;
            } else {
                arr[c - 97]++;
            }
            c = System.in.read();
        }

        int max = -1;
        int ch = -2; // ? = 63

        for (int i = 0; i < 26; i++) {
            if (arr[i] > max) {
                max = arr[i];
                ch = i;
            } else if (arr[i] == max) {
                ch = -2;
            }
        }
        System.out.println((char) (ch+65));
    }
}
