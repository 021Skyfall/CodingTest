package Programmers.lvl1;

public class EvenOddNum {
    public static void main(String[] args) {
        System.out.println(solution(-22));
    }

    public static String solution(int num) {
        if (num % 2 == 0) {
            return "Even";
        }
        return "Odd";
    }
}
