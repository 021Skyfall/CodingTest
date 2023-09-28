import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int close = findClose(nums, n, m);
        System.out.println(close);
    }

    static int findClose(int[] nums, int n, int m) {
        int result = 0;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int temp = nums[i] + nums[j] + nums[k];

                    if (m == temp) {
                        return temp;
                    }

                    if (result < temp && temp < m) {
                        result = temp;
                    }
                }
            }
        }
        return result;
    }
}
