package coplit;

// 문자열을 입력받아 연속되는 문자가 있을 경우, 연속 구간을 반복되는 수와 문자로 조합한 형태로 압축한 문자열을 리턴해야 합니다.

// 빈 문자열을 입력받은 경우, 빈 문자열을 리턴해야 합니다.
//3개 이상 연속되는 문자만 압축합니다.

public class compressString {
    public static void main(String[] args) {
        String output = compressString("wwwggoppopppp");
        System.out.println(output); // --> "3wggoppo4p"
    }
    public static String compressString(String str) {
        // 엣지
        if (str.length() == 0) return "";

        int count = 1;
        // 시작 기준 문자
        char old = str.charAt(0);
        // 결과
        StringBuilder result = new StringBuilder();
        // 제일 마지막 문자도 연속되는 경우 때문에 추가된 더미
        str = str + ' ';

        // 전달인자 문자열 길이만큼 반복
        // 기준 문자를 인덱스 0으로 잡았기 때문에 1부터 시작함
        for (int i = 1; i < str.length(); i++) {
            // 이전 문자와 다음 문자가 같다면
            if (old == str.charAt(i)) {
                count++;
            }
            // 같지 않다면
            else {
                // 이전 문자와 다음 문자가 같지 않지만 count가 3 이상이라면
                if (count >= 3) {
                    // 결과 담을 문자열 + 카운트 + 카운트 기준 문자
                    result.append(count).append(old);
                }
                // 3 이상이 아니라면
                else {
                    // 반복되었던 문자를 결과 문자열에 추가함
                    for (int j = 0; j < count; j++) {
                        result.append(old);
                    }
                }
                // 시작 기준 문자를 현재 지정된 문자로 치환
                old = str.charAt(i);
                // 다시 처음부터 카운트
                count = 1;
            }
        }
        return result.toString();
    }
}
