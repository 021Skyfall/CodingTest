import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 책의 개수 N을 입력 받음
        int N = Integer.parseInt(br.readLine());

        // 책의 가격을 저장할 배열 선언
        int[] prices = new int[N];

        // 책의 가격 입력 받음
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            prices[i] = Integer.parseInt(st.nextToken());
        }

        // 책의 가격을 오름차순으로 정렬
        Arrays.sort(prices);

        // 최소 페이지 수를 계산
        int pageCount = 1; // 적어도 하나의 페이지는 필요함
        int minPrice = prices[0]; // 현재 페이지의 최소 가격

        for (int i = 1; i < N; i++) {
            // 가격이 두 배 이상 차이 나는 경우, 새 페이지에서 진열
            if (prices[i] >= 2 * minPrice) {
                pageCount++;
                minPrice = prices[i]; // 새 페이지의 최소 가격 갱신
            }
        }

        // 필요한 최소 페이지 수 출력
        System.out.println(pageCount);

        br.close();
    }
}