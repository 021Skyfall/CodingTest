package coplit;

//문자열을 입력받아 아이소그램인지 여부를 리턴해야 합니다. 아이소그램(isogram)은 각 알파벳을 한번씩만 이용해서 만든 단어나 문구를 말합니다.

//빈 문자열을 입력받은 경우, true를 리턴해야 합니다.
//대소문자는 구별하지 않습니다.

public class isIsogram {
    public static void main(String[] args) {
        System.out.println(isIsogram("Dermatoglyphics")); // true
    }
    public static boolean isIsogram(String str) {
        String result = "";
        str = str.toLowerCase();

        for (int i = 0; i < str.length(); i++) {
            if (result.contains(String.valueOf(str.charAt(i)))) return false;
            else result += str.charAt(i);
        }
        return true;
    }
}
