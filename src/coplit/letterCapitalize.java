package coplit;

// 문자열을 입력받아 문자열을 구성하는 각 단어의 첫 글자가 대문자인 문자열을 리턴해야 합니다.

//단어는 공백으로 구분합니다.
//연속된 공백이 존재할 수 있습니다.
//빈 문자(공백)으로만 이루어진 문자열을 입력받은 경우, 빈 문자열을 리턴해야 합니다.

public class letterCapitalize {
    public static void main(String[] args) {
        String output1 = letterCapitalize("hello world");
        System.out.println(output1); // "Hello World"
    }
    private static String letterCapitalize(String str) {
        if (str.isEmpty()) return "";

        String[] arr = str.split(" ");
        String result;

        for(int i = 0; i < arr.length; i++) {
            arr[i] = String.valueOf(arr[i].charAt(0)).toUpperCase() + arr[i].substring(1);
        }
        result = String.join(" ", arr);
        return result;
    }
}
