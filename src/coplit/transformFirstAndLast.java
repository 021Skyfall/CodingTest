package coplit;

import java.util.HashMap;

// 배열을 입력받아 차례대로 배열의 첫 요소와 마지막 요소를 키와 값으로 하는 HashMap을 리턴해야 합니다.

//빈 배열을 입력받은 경우, null을 리턴해야 합니다.
//입력으로 받는 배열을 수정하지 않아야 합니다.

public class transformFirstAndLast {
    public static void main(String[] args) {
        String[] arr = new String[]{"Queen", "Elizabeth", "Of Hearts", "Beyonce"};
        HashMap<String, String> output = transformFirstAndLast(arr);
        System.out.println(output); // --> { Queen : 'Beyonce' }
    }
    private static HashMap<String, String> transformFirstAndLast(String[] arr) {
        if (arr.length == 0) return null;
        HashMap<String, String> result = new HashMap<>();
        result.put(arr[0],arr[arr.length-1]);
        return result;
    }
}