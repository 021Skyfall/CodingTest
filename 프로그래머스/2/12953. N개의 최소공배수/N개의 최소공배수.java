class Solution {
    public static int solution(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }

        // 최초 최대공약수, 최소공배수
        int gcd = gcd(arr[0], arr[1]);
        int lcm = (arr[0] * arr[1]) / gcd;

        // 최초 값으로부터 반복
        for (int i = 2; i < arr.length; i++) {
            gcd = gcd(lcm, arr[i]);
            lcm = (lcm * arr[i]) / gcd;
        }

        return lcm;
    }

    // 최소공배수 = (a * b) / 최대공약수
    // 최대공약수 유클리드 호제법
    public static int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }
}