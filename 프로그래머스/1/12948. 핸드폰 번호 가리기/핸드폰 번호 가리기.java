class Solution {
    public String solution(String phone_number) {
        int len = phone_number.length();

        StringBuilder result = new StringBuilder();
        result.append("*".repeat(Math.max(0, len - 4)));

        return result.append(String.copyValueOf(phone_number.toCharArray(), len - 4, 4)).toString();
    }
}