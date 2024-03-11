import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int total = m * k;

        Integer[] arr = new Integer[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (a, b) -> b - a);

        int sum = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            count++;
            if (sum >= total) {
                System.out.println(count);
                return;
            }
        }

        System.out.println("STRESS");
    }
}