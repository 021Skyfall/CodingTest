package baekjoon.입출력;

//두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.

import java.io.IOException;
import java.util.Scanner;

public class BJ_1000_1001_1008 {
    public static void main(String[] args) throws IOException {
        firstCal();

        secondaryCal();
    }

    private static void firstCal()  throws IOException {
        int a = System.in.read() - '0';
        System.in.read();
        int b = System.in.read() - '0';
        calculate(a, b);
    }

    private static void secondaryCal() {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        calculate(a, b);
    }

    private static void calculate(int a, int b) {
        long start = System.nanoTime();
        System.out.println(a + b);
        System.out.println(a - b);
        System.out.println(a * b);
        System.out.println(a / b);
        System.out.println(a % b);
        long end = System.nanoTime();
        System.out.println(end - start + " ns");
    }
}

// BufferReader 사용 실패
// https://st-lab.tistory.com/18 -> BufferReader 사용법