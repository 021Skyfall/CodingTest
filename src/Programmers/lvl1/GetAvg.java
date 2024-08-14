package Programmers.lvl1;

public class GetAvg {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,2,3,4}));
    }

    public static double solution(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }

        return (double) sum /arr.length;
    }
}
