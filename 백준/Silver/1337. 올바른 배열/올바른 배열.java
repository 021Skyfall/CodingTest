import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int answer = 4;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n && j - i + 1 <= 5; j++) {
                if (arr[j] - arr[i] <= 4) {
                    answer = Math.min(answer, 5 - (j - i + 1));
                } else {
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}