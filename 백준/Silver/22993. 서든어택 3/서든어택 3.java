import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 사람 수
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a1 = Long.parseLong(st.nextToken()); // 준원이의 공격력

        long[] arr = new long[n - 1]; // 나머지 공격력
        for (int i = 0; i < n - 1; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);
        for (long a : arr) {
            if (a1 > a) {
                a1 += a;
            } else {
                System.out.println("No");
                return;
            }
        }

        System.out.println("Yes");
    }
}