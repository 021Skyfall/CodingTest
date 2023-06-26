package coplit;

//두 수를 입력받아 거듭제곱을 리턴해야 합니다.

//Math.pow, 거듭제곱 연산자 사용은 금지됩니다.
//시간복잡도 O(logN)을 만족해야 합니다.
//나머지를 구하는 이유는 계산 결과가 컴퓨터로 나타낼 수 있는 수의 범위를 넘을 수 있기 때문입니다.
// 하지만 모든 연산이 끝난 뒤에 그 결과를 94,906,249로 나누려고 해서는 안 됩니다. 연산 중간에도 이 범위를 넘을 수 있기 때문에,
// 연산을 할 때마다 나머지를 구하고 그 결과에 연산을 이어가시기 바랍니다.

public class power {
    public static void main(String[] args) {
        long output = power(3, 40);
        System.out.println(output); // --> 19334827
    }
    private static long power(int base, int exponent) {
        if (exponent == 0) return 1;
        long result = power(base, exponent/2);
        if (exponent % 2 == 0) {
            return (result * result) % 94906249;
        } else {
            return (result * result * base) % 94906249;
        }
    }
}
