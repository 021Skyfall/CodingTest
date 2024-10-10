import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] bit = new int[32];
        int[] bitReversed = new int[32];

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int idx = 0;

        while (n != 0) {
            bit[idx] = n % 2;
            n /= 2;
            idx++;
        }

        // 1 -> 0, 0 -> 1
        for (int i = 0; i < 32; i++) {
            bitReversed[i] = bit[i] == 1 ? 0 : 1;
        }

        // 1을 더해줌
        bitReversed[0]++;

        for (int i = 0; i < 32; i++) {
            if (bitReversed[i] == 2) {
                bitReversed[i] = 0;
                if (i + 1 < 32) {
                    bitReversed[i + 1]++;
                }
            }
        }

        int diffCnt = 0;

        for (int i = 0; i < 32; i++) {
            if (bit[i] != bitReversed[i]) {
                diffCnt++;
            }
        }

        System.out.println(diffCnt);
        scanner.close();
    }
}