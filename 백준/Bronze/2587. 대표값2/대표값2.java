import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[5];

        for (int i = 0; i < 5; i++) {
            int n = Integer.parseInt(br.readLine());
            arr[i] = n;
        }

        arr = Arrays.stream(arr).sorted().toArray();
        int average = (int) Arrays.stream(arr).average().orElse(0);

        System.out.println(average);
        System.out.println(arr[2]);
    }
}