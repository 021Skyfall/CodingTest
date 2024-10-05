import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 두 문자열 입력 받기
        String x = sc.next();
        String y = sc.next();

        StringBuilder answer = new StringBuilder();

        // 두 문자열의 각 자리 수를 합쳐서 입력
        for (int i = 0; i < 8; i++) {
            answer.append(x.charAt(i)).append(y.charAt(i));
        }

        while (answer.length() != 2) {
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < answer.length() - 1; i++) {
                int sum = (Character.getNumericValue(answer.charAt(i)) + Character.getNumericValue(answer.charAt(i + 1))) % 10;
                temp.append(sum);
            }
            answer = temp;
        }

        System.out.println(answer);
    }
}