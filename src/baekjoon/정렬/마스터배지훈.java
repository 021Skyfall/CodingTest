package baekjoon.정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 마스터배지훈 {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 배열의 크기
        int m = Integer.parseInt(st.nextToken()); // 질의의 수

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr); // 배열 정렬

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int query = Integer.parseInt(br.readLine()); // 찾는 값
            sb.append(binarySearch(arr, query)).append('\n');
        }

        System.out.println(sb);
    }

    private static int binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] < key) {
                low = mid + 1;
            } else if (arr[mid] > key) {
                high = mid - 1;
            } else {
                // 같은 값을 가지는 가장 낮은 인덱스를 찾음
                while (mid > 0 && arr[mid - 1] == key) {
                    mid--;
                }
                return mid;
            }
        }

        return -1;
    }
}
