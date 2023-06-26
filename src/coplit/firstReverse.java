package coplit;

// 문자열을 입력받아 순서가 뒤집힌 문자열을 리턴해야 합니다.

//String 타입을 리턴해야 합니다.

public class firstReverse {
    public static void main(String[] args) {
        String output = firstReverse("codestates");
        System.out.println(output); // "setatsedoc"
    }
    private static String firstReverse(String str) {
        char[] arr = str.toCharArray();
        char[] result = new char[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[arr.length -1 -i] = arr[i];
        }
        return new String(result);
    }
}
