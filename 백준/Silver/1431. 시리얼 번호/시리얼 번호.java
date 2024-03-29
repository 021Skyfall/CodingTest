import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(br.readLine());
        }

        // comparator 구현
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                // 길이가 다르면 짧은 순
                if (s1.length() != s2.length()) {
                    return s1.length() - s2.length();
                }

                // 길이가 같으면 문자의 숫자 합
                int sum1 = sumNumbers(s1);
                int sum2 = sumNumbers(s2);
                if (sum1 != sum2) {
                    return sum1 - sum2;
                }

                // 그 외의 경우 사전 순
                return s1.compareTo(s2);
            }

            // 문자열 내부 숫자의 합 계산
            private int sumNumbers(String str) {
                int sum = 0;
                for (char c : str.toCharArray()) {
                    if (Character.isDigit(c)) {
                        sum += c -'0';
                    }
                }

                return sum;
            }
        });

        // 정렬된 리스트 출력
        for (String s : list) {
            System.out.println(s);
        }
    }
}