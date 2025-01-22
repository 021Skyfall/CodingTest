import java.util.Scanner;

public class Main {
    static int[] arr = new int[1000001];

    public static void main(String[] args) {
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 1;

        // 에라토스테네스의 체
        for (int i = 2; i * i < 1000000; i++) {
            if (arr[i] == 0) {
                for (int j = i * i; j < 1000000; j += i) {
                    arr[j] = 1;
                }
            }
        }

        Scanner scanner = new Scanner(System.in);

        while (true) {
            int n = scanner.nextInt();
            if (n == 0) break;

            int left = 3;
            int right = n - 3;

            while (left <= right) {
                if (arr[left] == 0 && arr[right] == 0) {
                    if ((left + right) == n) {
                        break;
                    }
                }
                left += 2;
                right -= 2;
            }

            if (left > right) {
                System.out.println("Goldbach's conjecture is wrong.");
            } else {
                System.out.println(n + " = " + left + " + " + right);
            }
        }
        scanner.close();
    }
}