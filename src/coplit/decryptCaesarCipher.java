package coplit;

//암호화된 문자열과 암호화 키를 입력받아 복호화된 문자열을 리턴해야 합니다.
//카이사르 암호(Caesar cipher)는 평문(plaintext)을 암호키 secret개만큼 (오른쪽으로) 평행이동시켜 암호화 합니다. 복호화는 암호화된 문자열을 원래의 평문으로 복원하는 것을 말합니다.

//빈 문자열을 입력받은 경우, 빈 문자열을 리턴해야 합니다.
//공백은 그대로 두어야 합니다.
//입력된 문자열은 모두 소문자만 입력됩니다.

public class decryptCaesarCipher {
    public static void main(String[] args) {
        String output = decryptCaesarCipher("khoor", 3);
        System.out.println(output); // --> hello
    }
    public static String decryptCaesarCipher(String str, int secret) {
        // 기준 알파벳
        String al = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder result = new StringBuilder();

        // 전달인자 str 길이 만큼 반복
        for (int i = 0; i < str.length(); i++) {
            // 공백은 그대로 리턴
            if (str.charAt(i) == ' ') result.append(str.charAt(i));
            else {
                // 기준 알파벳에서 현재 문자의 인덱스를 찾음
                int asis = al.indexOf(str.charAt(i));
                // 복호화는 반대이기 때문에 secret을 뺌
                // 알파벳을 넘어가게 되면 알파벳 길이를 더해주고 알파벳 길이 나눈 나머지를 리턴
                int tobe = (asis - secret + al.length()) % al.length();
                // 알파벳의 해당 문자열
                result.append(al.charAt(tobe));
            }
        }
        return result.toString();
    }
}
