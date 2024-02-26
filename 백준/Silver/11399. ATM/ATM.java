import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

        int result = 0;
        for (int i = 0; i < n; i++) {
            result += arr[i];
            for (int j = 0; j < i; j++) {
                result += arr[j];
            }
        }

        System.out.println(result);
    }
}