package coplit;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class g_convertListToObject {
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
