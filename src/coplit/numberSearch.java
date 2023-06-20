package coplit;

//문자열을 입력받아 문자열에서 숫자를 모두 찾아 더한 뒤에 해당 값을 (숫자와 공백을 제외한 나머지) 문자열의 길이로 나눈 값을 정수로 반올림하여 리턴해야 합니다.

//빈 문자열을 입력받은 경우, 0을 리턴해야 합니다.
//숫자(digit)는 연속해서 등장하지 않습니다.

public class numberSearch {
    public static void main(String[] args) {
        System.out.println(numberSearch("Hello6 9World 2,")); // --> 2
    }
    public static int numberSearch(String str) {
        // 찾아야 하는 숫자를 문자열로 모두 선언
        String digits = "0123456789";

        //엣지
        if (str.length() == 0) return 0;

        // 숫자를 카운트할 변수와, 숫자를 제외한 문자열을 저장할 변수 선언
        double sum = 0;
        String pureStr = "";

        // 문자열을 순회
        for (int i = 0; i < str.length(); i++) {
            //digits 의 값에서 str[i]의 값이 포함되어 있다면
            //(indefxOf는 값이 존재하면 해당 인덱스를, 없다면 -1을 리턴)
            if (digits.indexOf(str.charAt(i)) != -1) {
                // 찾을 숫자를 모두 더함
                sum += Character.getNumericValue(str.charAt(i));
                // 존재 하지 않고 공백이 아니라면
            } else if (str.charAt(i) != ' ') {
                pureStr += str.charAt(i);
            }
        }
        // 결과 계산, 숫자를 문자열의 길이로 나눈 후
        double result = sum / pureStr.length();
        // 소수점으로부터 반올림 후 리턴
        return (int) Math.round((result * 10) / 10);
    }
}
