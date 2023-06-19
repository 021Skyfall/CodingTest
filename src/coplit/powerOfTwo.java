package coplit;

// 수를 입력받아 2의 거듭제곱인지 여부를 리턴해야 합니다.

//반복문(while)문을 사용해야 합니다.
//2의 0승은 1입니다.
//Math.log 사용은 금지됩니다.

public class powerOfTwo {
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
