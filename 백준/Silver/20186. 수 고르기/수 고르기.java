import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 배열 전환
        Integer[] arr = new Integer[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 내림차순 정렬
        Arrays.sort(arr, (a, b) -> b - a);

        // 상위 k개의 합
        long sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        // 최종 점수 : 상위 k개 숫자 합에서 k * (k - 1) / 2 만큼 뺌
        sum -= k * (k - 1) / 2;

        System.out.println(sum);
    }
}