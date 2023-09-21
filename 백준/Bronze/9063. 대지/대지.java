import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            String[] cur = br.readLine().split(" ");
            int x = Integer.parseInt(cur[0]);
            int y = Integer.parseInt(cur[1]);

            max1 = Math.max(max1,x);
            max2 = Math.max(max2,y);

            min1 = Math.min(min1, x);
            min2 = Math.min(min2, y);

        }

        System.out.println((max1 - min1) * (max2 - min2));
    }
}