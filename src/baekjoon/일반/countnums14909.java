package baekjoon.일반;

import java.util.Scanner;

public class countnums14909 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = 0;

        while (scanner.hasNextInt()) {
            int a = scanner.nextInt();
            if (a > 0) {
                num++;
            }
        }

        System.out.println(num);
        scanner.close();
    }
}
