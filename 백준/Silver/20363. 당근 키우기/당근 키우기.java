import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x = scanner.nextInt();
        int y = scanner.nextInt();

        // 더 큰 값에 더 작은 값의 10%를 추가하여 계산
        int ans = Math.max(x, y) + Math.min(x, y) + Math.min(x, y) / 10;

        System.out.println(ans);
        scanner.close();
    }
}