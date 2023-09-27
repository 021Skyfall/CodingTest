import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");

        int a1 = Integer.parseInt(arr[0]);
        int a2 = Integer.parseInt(arr[1]);
        int c = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        System.out.println((a1 * n + a2 <= c * n) && (c >= a1)? 1:0);
    }
}