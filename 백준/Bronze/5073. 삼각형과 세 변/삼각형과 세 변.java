import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws java.io.IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        while (true) {
            String[] tri = br.readLine().split(" ");
            int x = Integer.parseInt(tri[0]);
            int y = Integer.parseInt(tri[1]);
            int z = Integer.parseInt(tri[2]);
            int sum = x + y + z;

            if (sum == 0) {
                break;
            }

            int max = 0;
            int second = 0;
            for (int i = 0 ; i < 3; i++) {
                int cur = Integer.parseInt(tri[i]);

                if (cur > max) {
                    second = max;
                    max = cur;
                }
                else if (cur > second)
                    second = cur;
            }
            int rest = (x+y+z) - max;

            if (max >= rest) {
                System.out.println("Invalid");
            } else {
                if (x == z && y == z)
                    System.out.println("Equilateral");
                else if (x == y || x == z ||y == z)
                    System.out.println("Isosceles");
                else
                    System.out.println("Scalene");
            }
        }
    }
}