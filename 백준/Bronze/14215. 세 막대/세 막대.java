import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int z = Integer.parseInt(st.nextToken());

        br.close();

        int max = 0;
        if (x > y) {
            if (y > z) max = x;
            else max = Math.max(x, z);
        } else {
            max = Math.max(y, z);
        }

        if (x + y + z - max > max) System.out.println(x + y + z);
        else System.out.println((x + y + z - max) * 2 - 1);
    }
}