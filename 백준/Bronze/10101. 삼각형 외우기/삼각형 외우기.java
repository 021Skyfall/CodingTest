import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());
        int z = Integer.parseInt(br.readLine());
        int sum = x + y + z;

        if (sum == 180) {
            if (x == 60 && y == 60 && z == 60)
                System.out.println("Equilateral");
            else if (x == y || x == z || y == z)
                System.out.println("Isosceles");
            else System.out.println("Scalene");
        }
        else System.out.println("Error");
    }
}