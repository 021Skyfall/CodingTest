import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        br.close();

        Arrays.sort(nums);
        int[] result = new int[4];
        result[0] = sum(nums);
        result[1] = middle(nums);
        result[2] = fre(nums);
        result[3] = range(nums);

        for (int i = 0; i < 4; i++) {
            System.out.println(result[i]);
        }
    }

    static int sum(int[] arr) {
        int s = 0;
        for (int i : arr) {
            s += i;
        }

        return Math.round((float) s /arr.length);
    }

    static int middle(int[] arr) {
        return arr[arr.length/2];
    }

    static int fre(int[] arr) {
        HashMap<Integer, Integer> frequency = new HashMap<>();

        for (int e : arr) {
            frequency.put(e, frequency.getOrDefault(e, 0) + 1);
        }

        int max = Collections.max(frequency.values());

        ArrayList<Integer> most = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            if (entry.getValue() == max) {
                most.add(entry.getKey());
            }
        }

        if (most.size() == 1) {
            return most.get(0);
        } else {
            Collections.sort(most);
            return most.get(1);
        }
    }

    static int range(int[] arr) {
        return arr[arr.length - 1] - arr[0];
    }
}