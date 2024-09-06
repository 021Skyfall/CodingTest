class Solution {
    public boolean solution(String s) {
        if (s.length() != 4 && s.length() != 6) {
            return false;
        }
        
        try {
            Long.parseLong(s);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }
}