import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            if(n == 0) break; // 입력의 마지막 조건

            ArrayList<Integer> nonZeroNums = new ArrayList<>();
            int zeroCount = 0;
            // 0이 아닌 숫자와 0의 개수 세기
            for(int i = 1; i <= n; i++) {
                int num = Integer.parseInt(input[i]);
                if(num == 0) zeroCount++;
                else nonZeroNums.add(num);
            }
            Collections.sort(nonZeroNums);

            StringBuilder num1 = new StringBuilder();
            StringBuilder num2 = new StringBuilder();

            // 처음 0이 아닌 두 숫자를 두 숫자의 시작으로 사용
            num1.append(nonZeroNums.remove(0));
            if (!nonZeroNums.isEmpty()) {
                num2.append(nonZeroNums.remove(0));
            }

            // 남은 숫자 번갈아가며 추가
            boolean appendToNum1 = true;
            for (int num : nonZeroNums) {
                if (appendToNum1) num1.append(num);
                else num2.append(num);
                appendToNum1 = !appendToNum1;
            }

            // 0 추가
            while (zeroCount-- > 0) {
                if (num1.length() <= num2.length()) num1.insert(1, '0');
                else num2.insert(1, '0');
            }

            int result = Integer.parseInt(num1.toString()) + Integer.parseInt(num2.toString());
            System.out.println(result);
        }
    }
}