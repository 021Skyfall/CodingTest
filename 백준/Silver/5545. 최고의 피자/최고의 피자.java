import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 토핑 종류 수

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()); // 도우 가격
        int b = Integer.parseInt(st.nextToken()); // 토핑 가격
        int c = Integer.parseInt(br.readLine()); // 도우 열량

        // 토핑 열량
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        list.sort(Comparator.reverseOrder());

        int totalPrice = a; // 초기 피자 가격
        int totalCalories = c; // 초기 피자 열량
        double maxRatio = (double) c / a; // 최고 피자

        for (int i = 0; i < n; i++) {
            int toppingCalories = list.get(i);
            totalPrice += b; // 토핑 가격 추가
            totalCalories += toppingCalories; // 토핑 열량 추가
            double curRatio = (double) totalCalories / totalPrice; // 최고 피자 계산

            // 현재 최고가 이전 최고보다 높으면 갱신
            if (curRatio > maxRatio) {
                maxRatio = curRatio;
            } else {
                // 토핑 추가로 최고 비율이 더 이상 증가하지 않으면 종료
                break;
            }
        }

        System.out.println((int) maxRatio);
    }
}