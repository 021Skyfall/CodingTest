package coplit;

// 문자열을 입력받아 문자열을 구성하는 각 단어의 첫 글자로 이루어진 문자열을 리턴해야 합니다.

//단어는 공백 한 칸으로 구분합니다.
//연속된 공백은 없다고 가정합니다.
//빈 문자열을 입력받은 경우, 빈 문자열을 리턴해야 합니다.

public class firstCharacter {
    public static void main(String[] args) {
        String output = firstCharacter("hello world");
        System.out.println(output); // --> "hw"
    }
    public static String firstCharacter(String str) {
        if (str.isEmpty()) return "";
        String[] split = str.split(" ");
        String result = "";
        for (String i : split) {
            result += i.charAt(0);
        }

        return result;
    }
}
