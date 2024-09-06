class Solution {
    public int[] solution(int n, int m) {
        int[] result = new int[2];

        int gcd = gcd(n, m);
        result[0] = gcd;

        // LCM
        result[1] = (n * m) / gcd;

        return result;
    }

    // gcd
    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}