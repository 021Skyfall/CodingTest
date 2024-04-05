import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] arr;
    static int[] temp;
    static int k;
    static int curCount =0;

    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        temp = new int[a];

        mergeSort(0, a - 1);

        if (curCount < k) {
            System.out.println(-1);
        }
    }

    private static void mergeSort(int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(left, mid);
            mergeSort(mid + 1, right);

            merge(left, mid, right);
        }
    }

    private static void merge(int left, int mid, int right) {
        int l = left;
        int r = mid + 1;
        int idx = left;

        while (l <= mid && r <= right) {
            if (arr[l] <= arr[r]) {
                temp[idx++] = arr[l++];
            } else {
                temp[idx++] = arr[r++];
            }

            if (++curCount == k) {
                System.out.println(temp[idx - 1]);
                System.exit(0);
            }
        }

        while (l <= mid) {
            temp[idx++] = arr[l++];
            if (++curCount == k) {
                System.out.println(temp[idx - 1]);
                System.exit(0);
            }
        }

        while (r <= right) {
            temp[idx++] = arr[r++];
            if (++curCount == k) {
                System.out.println(temp[idx - 1]);
                System.exit(0);
            }
        }

        for (int i = left; i <= right; i++) {
            arr[i] = temp[i];
        }
    }
}