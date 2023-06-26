package coplit;

//문자열을 요소로 갖는 배열을 입력받아 문자열을 세로로 읽었을 때의 문자열을 리턴해야 합니다.

//각 문자열의 길이는 다양합니다.
//각 문자의 위치를 행, 열로 나타낼 경우, 비어있는 (행, 열)은 무시합니다.

public class readVertically {
    public static void main(String[] args) {
        String[] input = new String[]{
                "hello",
                "wolrd",
        };
        String output = readVertically(input);
        System.out.println(output); // --> "hweolllrod"
    }
    private static String readVertically(String[] arr) {
        // 배열 요소 중 가장 긴 길이 추출
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i].length()) max = arr[i].length();
        }

        // 배열의 문자를 순회하며 추출
        String[] result = new String[max];
        for (int i = 0; i < arr.length; i++) {
            String str = arr[i];
            // 해당 문자열 길이 만큼 반복 후 str 배열에 하나씩 추출 후 할당
            for (int j = 0; j < str.length(); j++) {
                if (result[j] == null) {
                    result[j] = Character.toString(str.charAt(j));
                } else {
                    result[j] += str.charAt(j);
                }
            }
        }
        // 결과 값
        String str = "";
        // 배열 -> 문자열
        for (int i = 0; i < result.length; i++) {
            str += result[i];
        }
        return str;
    }
}
