package coplit;

public class d_firstCharacter {
    public static void main(String[] args) {
        String output = firstCharacter("hello world");
        System.out.println(output); // --> "hw"
    }
    public static String firstCharacter(String str) {
        if (str.isEmpty()) return "";
        String[] split = str.split(" ");
        String result = "";
        for (String i : split) {
            result += i.charAt(0);
        }

        return result;
    }
}
