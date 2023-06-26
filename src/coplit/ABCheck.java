package coplit;

//문자열을 입력받아 문자열 내에 아래 중 하나가 존재하는지 여부를 리턴해야 합니다.
//'a'로 시작해서 'b'로 끝나는 길이 5의 문자열
//'b'로 시작해서 'a'로 끝나는 길이 5의 문자열

//대소문자를 구분하지 않습니다.
//공백도 한 글자로 취급합니다.
//'a'와 'b'는 중복해서 등장할 수 있습니다.

public class ABCheck {
    public static void main(String[] args) {
        boolean output = ABCheck("lane Borrowed");
        System.out.println(output); // --> true
    }
    private static boolean ABCheck(String str) {
        str = str.toLowerCase();
        for (int i = 4; i < str.length(); i++) {
            if (str.charAt(i-4) == 'a' && str.charAt(i) == 'b' ||
            str.charAt(i-4) == 'b' && str.charAt(i) == 'a') {
                return true;
            }
        }
        return false;
    }
}
