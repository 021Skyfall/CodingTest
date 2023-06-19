package coplit;

//문자열을 요소로 갖는 배열을 입력받아 가장 짧은 문자열과 가장 긴 문자열을 제거한 배열을 리턴해야 합니다.

//가장 짧은 문자열의 길이와 가장 긴 문자열의 길이가 같은 경우는 없습니다.
//가장 짧은 문자열 또는 가장 긴 문자열이 다수일 경우, 나중에 위치한 문자열을 제거합니다.
//공백을 입력받을 경우, null을 반환합니다.

//String 타입을 요소로 갖는 배열
//arr[i].length()는 20 이하

import java.util.Arrays;

public class removeExtremes {
    public static void main(String[] args) {
        String[] output = removeExtremes(new String[]{"where", "is", "the", "longest", "word"});
        System.out.println(Arrays.toString(output)); // --> ["where", "the", "word"]
    }
    public static String[] removeExtremes(String[] arr) {
        if (arr.length == 0) return null;

        String[] result = new String[arr.length-2];

        // 가장 짧은 경우
        int shorten = 20;
        // 가장 긴 경우
        int longest = 0;

        //작은 요소의 인덱스
        int sIdx = 0;
        // 큰 요소의 인덱스
        int lIdx = 0;

        //요소 하나씩 비교
        for (int i = 0; i < arr.length; i++) {
            // 짧은 경우
            if (arr[i].length() <= shorten) {
                shorten = arr[i].length();
                sIdx = i;
            }
            // 긴 경우
            if (arr[i].length() >= longest) {
                longest = arr[i].length();
                lIdx = i;
            }
        }

        //결과 출력
        int cur = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i != lIdx && i != sIdx) {
                result[cur] = arr[i];
                cur++;
            }
        }
        return result;
    }
}
