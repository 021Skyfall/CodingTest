class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        int idx = 0;

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if (currentChar == ' ') {
                sb.append(currentChar);
                idx = 0;
            } else {
                if (idx % 2 == 0) {
                    sb.append(Character.toUpperCase(currentChar));
                } else {
                    sb.append(Character.toLowerCase(currentChar));
                }
                idx++;
            }
        }

        return sb.toString();
    }
}