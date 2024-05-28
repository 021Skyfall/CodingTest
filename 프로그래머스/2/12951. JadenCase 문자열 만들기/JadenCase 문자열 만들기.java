class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder(s.toLowerCase());
        boolean isNewWord = true;

        for (int i = 0; i < sb.length(); i++) {
            char currentChar = sb.charAt(i);

            if (isNewWord && Character.isLetter(currentChar)) {
                sb.setCharAt(i, Character.toUpperCase(currentChar));
                isNewWord = false;
            } else if (currentChar == ' ') {
                isNewWord = true;
            } else {
                isNewWord = false;
            }
        }

        return sb.toString();
    }
}