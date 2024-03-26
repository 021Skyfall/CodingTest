import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스 개수
        int t = Integer.parseInt(br.readLine());

        while (t > 0) {

            ArrayList<Integer> list = new ArrayList<>();
            // 소지금
            long money = (long) (5 * Math.pow(10, 6));

            int n; // 땅 값
            while ((n = Integer.parseInt(br.readLine())) != 0) {
                list.add(n);
            }

            list.sort(Collections.reverseOrder()); //  땅값 -> 내림차순 정렬 후 연산
            
            long sum = 0; // 결과값
            int j = 1; // 연차
            for (Integer v : list) {
                sum += (2 * (long) (Math.pow(v, j)));
                j++;
            }

            if (money < sum) {
                System.out.println("Too expensive");
            } else {
                System.out.println(sum);
            }

            t--;
        }
    }
}