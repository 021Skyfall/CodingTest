import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if (n == 0) {
            System.out.println(0);
            return;
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            list.add(num);
        }

        list.sort(Comparator.comparingInt(e -> e));

        int percentage = (int) Math.round(list.size() * 0.15);
        int sum = 0;
        for (int i = percentage; i < list.size() - percentage; i++) {
            sum += list.get(i);
        }

        System.out.println(Math.round((float) sum / (list.size() - (2 * percentage))));
    }
}