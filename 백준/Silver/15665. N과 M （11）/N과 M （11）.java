import java.util.*;

public class Main {
    static int n, m;
    static int[] nums;
    static Set<Integer> uniqueNums = new HashSet<>();
    static List<String> answer = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();
        scanner.nextLine(); 

        String[] inputNums = scanner.nextLine().split(" ");
        for (String num : inputNums) {
            uniqueNums.add(Integer.parseInt(num));
        }

        nums = uniqueNums.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(nums);

        solve(new ArrayList<>());

        for (String str : answer) {
            System.out.println(str);
        }

        scanner.close();
    }

    static void solve(List<Integer> arr) {
        if (arr.size() == m) {
            StringBuilder sb = new StringBuilder();
            for (int num : arr) {
                sb.append(num).append(" ");
            }
            answer.add(sb.toString().trim()); 
        } else {
            for (int i = 0; i < nums.length; i++) {
                arr.add(nums[i]);
                solve(arr);
                arr.remove(arr.size() - 1);
            }
        }
    }
}