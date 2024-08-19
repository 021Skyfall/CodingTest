class Solution {
    public String solution(String s) {
        int length = s.length();
        int mid = length / 2;


        if (length % 2 == 0) {
            return s.substring(mid - 1, mid + 1);
        } else {
            return s.substring(mid, mid + 1);
        }
    }
}