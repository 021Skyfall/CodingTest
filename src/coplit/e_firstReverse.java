package coplit;

public class e_firstReverse {
    public static void main(String[] args) {
        String output = firstReverse("codestates");
        System.out.println(output); // "setatsedoc"
    }
    public static String firstReverse(String str) {
        char[] arr = str.toCharArray();
        char[] result = new char[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[arr.length -1 -i] = arr[i];
        }
        return new String(result);
    }
}
