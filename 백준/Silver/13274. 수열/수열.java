import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long[] arr = new long[n];
        long[] temp = new long[n]; // 임시 배열 추가
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr); // 초기 배열 정렬

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken()) - 1;
            int r = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            int idx = 0;
            int it = l;
            for (int j = 0; j < l; j++) {
                while (it < r && arr[it] + x <= arr[j]) {
                    temp[idx++] = arr[it++] + x;
                }
                temp[idx++] = arr[j];
            }
            for (int j = r; j < n; j++) {
                while (it < r && arr[it] + x <= arr[j]) {
                    temp[idx++] = arr[it++] + x;
                }
                temp[idx++] = arr[j];
            }
            while (it < r) {
                temp[idx++] = arr[it++] + x;
            }
            // 임시 배열의 값을 원본 배열로 복사
            for (int j = 0; j < n; j++) {
                arr[j] = temp[j];
            }
        }

        // 결과 출력
        for (long num : arr) {
            System.out.print(num + " ");
        }
    }
}