import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new TreeMap<>();
        while (n-- > 0) {
            String str = br.readLine();
            String[] arr = str.split("\\.");
            map.put(arr[1], map.getOrDefault(arr[1], 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> set : map.entrySet()) {
            sb.append(set.getKey()).append(" ").append(set.getValue()).append('\n');
        }

        System.out.println(sb);
    }
}