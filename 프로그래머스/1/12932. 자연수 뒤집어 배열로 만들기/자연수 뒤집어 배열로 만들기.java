class Solution {
    public int[] solution(long n) {
        String str = String.valueOf(n);
        int length = str.length();
        int[] result = new int[length];

        for (int i = 0; i < length; i++){
            result[i] = Character.getNumericValue(str.charAt(length - 1 - i));
        }

        return result;
    }
}