package coplit;

public class f_letterCapitalize {
    public static void main(String[] args) {
        String output1 = letterCapitalize("hello world");
        System.out.println(output1); // "Hello World"
    }
    public static String letterCapitalize(String str) {
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
