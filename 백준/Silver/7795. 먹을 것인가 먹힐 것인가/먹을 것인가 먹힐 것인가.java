import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스
        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            List<Integer> A = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                A.add(Integer.parseInt(st.nextToken()));
            }

            List<Integer> B = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                B.add(Integer.parseInt(st.nextToken()));
            }

            // B 집합 오름차순 (작은것부터 비교)
            Collections.sort(B);

            // 비교 - 이진 탐색
            int result = 0;
            for (int i = 0; i < n; i++) {
                int aNum = A.get(i);
                int idx = lower(B, aNum);
                result += idx;
            }

            System.out.println(result);
        }
    }

    // 비교 함수 - 이진 탐색
    private static int lower(List<Integer> B, int target) {
        int low = 0, high = B.size();
        while (low < high) {
            int mid = (low + high) / 2;
            if (B.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low; // target 보다 작은 원소들의 개수
    }
}