import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 정수 개수
        int n = Integer.parseInt(br.readLine());

        // 정수 배열
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // 목표 값
        int x = Integer.parseInt(br.readLine());

        // 배열 올림차순 정렬
        Arrays.sort(arr);

        // 앞 뒤로 덧셈 후 x 에 도달하는 지 체크
        // 투 포인터
        int start = 0;
        int end = n - 1;
        int sum = 0;
        int result = 0;
        while (start < end) {
            sum = arr[start] + arr[end];
            if (sum == x) result++;
            if (sum < x) {
                start++;
            } else {
                end--;
            }
        }

        System.out.println(result);
    }
}