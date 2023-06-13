package coplit;

// 수를 입력받아 2의 거듭제곱인지 여부를 리턴해야 합니다.

public class c_powerOfTwo {
    public static void main(String[] args) {
        boolean output1 = powerOfTwo(16);
        System.out.println(output1); // true
    }
    public static boolean powerOfTwo(long num) {
        if (num == 1) return true;

        long x = 2;
        while (x < num) {
            x *= 2;
        }
        return x == num;
    }
}
