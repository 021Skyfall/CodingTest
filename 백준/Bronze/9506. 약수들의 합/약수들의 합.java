import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());

            if (n == -1) break;

            ArrayList<Integer> list = new ArrayList<>();

            for (int i = 1; i < n; i++) {
                if (n % i == 0) {
                    list.add(i);
                }
            }

            int sum = 0;
            for (int i : list) {
                sum += i;
            }

            if (sum == n) {
                System.out.print(n + " = 1");
                for (int i = 1; i < list.size(); i++) {
                    System.out.print(" + " + list.get(i));
                }
                System.out.println();
            }
            else System.out.println(n + " is NOT perfect.");

        }
    }
}