import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, k;
    static int[] arr;

    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        k = Integer.parseInt(br.readLine());

        int section = n / k;
        for (int i = 0; i < k; i++) {
            Arrays.sort(arr, i * section, (i + 1) * section);
        }

        StringBuilder sb = new StringBuilder();
        for (int a : arr) {
            sb.append(a).append(" ");
        }

        sb.deleteCharAt(sb.length() -1);

        System.out.println(sb);
    }
}