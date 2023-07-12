package baekjoon.입출력;

import java.util.Arrays;
import java.util.Scanner;

public class LinePlus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] result = str.split(" ");
        System.out.println(
                Arrays.stream(result).mapToLong(Long::parseLong).sum()
        );
    }
}
