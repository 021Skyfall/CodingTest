import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String num = br.readLine();
        br.close();
        int[] arr = new int[num.length()];

        for (int i = 0; i < num.length(); i++) {
            arr[i] = Integer.parseInt(String.valueOf(num.charAt(i)));
        }

        Integer[] result = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(result, Comparator.reverseOrder());
        for (int i = 0; i < result.length; i++) {
            sb.append(result[i]);
        }

        System.out.println(sb);
    }
}