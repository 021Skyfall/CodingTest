package coplit;

import java.util.HashMap;
import java.util.LinkedHashMap;

//2차원 배열(배열을 요소로 갖는 배열)을 입력받아 각 배열을 이용해 만든 HashMap을 리턴해야 합니다.

//중복되는 키의 경우, 초기의 값을 사용합니다.
//빈 배열을 입력받은 경우, 빈 HashMap을 리턴해야 합니다.
//arr[i]의 길이가 0인 경우, 무시합니다.

public class convertListToObject {
    public static void main(String[] args) {
        String[][] arr = new String[][]{
                {"make", "Ford"},
                {"model", "Mustang"},
                {"year", "1964"},
                {"make", "Bill"},
        };

        HashMap<String, String> output = convertListToHashMap(arr);
        System.out.println(output);
    }
    public static HashMap<String, String> convertListToHashMap(String[][] arr) {
        HashMap<String, String> map = new LinkedHashMap<>();
        if (arr.length == 0) return map;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 0) {
                if (!map.containsKey(arr[i][0])) map.put(arr[i][0], arr[i][1]);
            }
        }
        return map;
    }
}
