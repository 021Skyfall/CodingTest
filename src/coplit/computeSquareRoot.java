package coplit;

//수를 입력받아 제곱근 값을 소수점 두 자리까지 리턴해야 합니다.

//소수점 처리는 java 표준 내장 객체인 String를 검색해 봅니다. (java decimal places limit 또는 자바 소수점 자리수)
//각 자리수(1, 0.1, 0.01, 0.001)마다 (목표값을 넘지 않는) 근사값을 구하는 방식이 있습니다.
//제곱근을 구하는 방법 중 바빌로니아 법이 있습니다. 바빌로니아 법의 점화식(recurrence formula)을 이해할 수 있다면, 해당 식을 이용해 문제를 풀어도 좋습니다.

public class computeSquareRoot {
    public static void main(String[] args) {
        String output = computeSquareRoot(6);
        System.out.println(output); // --> "2.45"
    }
    public static String computeSquareRoot(int num) {
        // 소수점 3자리부터 반올림, 배열에 소수점 자리만큼 double 값 할당
        double[] diffs = new double[]{1, 0.1, 0.01, 0.001};
        // 초기값으로 1 설정
        double base = 1;

        // 선언된 배열 순회
        for (int i = 0; i < diffs.length; i++) {
            // 초기값을 곱했을 때, 입력된 값보다 작으면
            while (base * base < num) {
                base += diffs[i];
            }
            // 모두 더한 값이 입력된 num과 일치한다면 (즉, 더 이상 낮은 값과 비교할 필요가 없는 경우)
            if (base * base == num) {
                // 소수점 2자리까지의 값을 String으로 변환 후 리턴
                return String.format("%.2f", base);
            } else {
                // 기본 값에서 배열의 인자를 제외
                // 제외 -> 배열의 인자가 바뀌고, while 정상 순회 가능
                base -= diffs[i];
            }
        }
        return String.format("%.2f",base);
    }
}
