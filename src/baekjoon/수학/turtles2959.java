package baekjoon.수학;

import java.util.Arrays;
import java.util.Scanner;

public class turtles2959 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int[] numbers = Arrays.stream(input.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Arrays.sort(numbers);

        int result = numbers[0] * numbers[2];

        System.out.println(result);

        scanner.close();
    }
}
