import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Integer> tips = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tips.add(Integer.parseInt(br.readLine()));
        }

        tips.sort(Collections.reverseOrder());

        long total = 0;
        for (int i = 0; i < n; i++) {
            long tip = tips.get(i) - i;
            if (tip > 0) {
                total += tip;
            }
        }

        System.out.println(total);
    }
}