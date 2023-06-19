package coplit;

//문자열을 입력받아 연속된 한자리 홀수 숫자 사이에 '-'를 추가한 문자열을 리턴해야 합니다.

//0은 짝수로 간주합니다.

public class insertDash {
    public static void main(String[] args) {
        String output = insertDash("454793");
        System.out.println(output); // --> 4547-9-3
    }
    public static String insertDash(String str) {
        String result = String.valueOf(str.charAt(0));

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i-1) % 2 == 1 && str.charAt(i) % 2 == 1) {
                result += "-";
            }
            result += str.charAt(i);
        }
        return result;
    }
}
