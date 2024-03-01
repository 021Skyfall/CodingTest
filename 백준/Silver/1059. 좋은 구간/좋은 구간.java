import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int l = Integer.parseInt(br.readLine());

        int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

        int n = Integer.parseInt(br.readLine());

        int idx = Arrays.binarySearch(s, n);

        if (idx >= 0) {
            System.out.println(0);
            return;
        }

        idx = -(idx + 1);
        int left = (idx == 0) ? 1 : s[idx - 1] + 1;
        int right = s[idx] - 1;

        System.out.println((n - left + 1) * (right - n + 1) - 1);
    }
}