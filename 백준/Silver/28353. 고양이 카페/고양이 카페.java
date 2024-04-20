import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] weights = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(weights);

        int leftW = 0;
        int rightW = n - 1;
        int count = 0;

        while (leftW < rightW) {
            if (weights[leftW] + weights[rightW] <= k) {
                count++;
                leftW++;
                rightW--;
            } else {
                rightW--;
            }
        }

        System.out.println(count);
    }
}