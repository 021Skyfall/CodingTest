import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Integer[] straws = new Integer[n];

        for (int i = 0; i< n; i++) {
            straws[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(straws, (a, b) -> b - a);

        for (int i = 0; i < n - 2; i++) {
            if (straws[i] < straws[i + 1] + straws[i + 2]) {
                System.out.println(straws[i] + straws[i + 1] + straws[i + 2]);
                return;
            }
        }

        System.out.println(-1);
    }
}