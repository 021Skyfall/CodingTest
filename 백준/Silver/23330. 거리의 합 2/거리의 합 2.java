import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[] x = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            x[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(x);

        long sum = 0;
        for (int i = 0; i < n; i++) {
            // 각 점의 기여도 계산: 자기보다 작은 모든 점들로부터의 거리의 합 - 자기보다 큰 모든 점들로부터의 거리의 합
            sum += x[i] * i - x[i] * (n - 1 - i);
        }

        System.out.println(Math.abs(sum) * 2); // 모든 쌍의 거리 합은 절대값을 취한 후 2배 해야 함
    }
}