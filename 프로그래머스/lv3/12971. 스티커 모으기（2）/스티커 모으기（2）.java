class Solution {
    public int solution(int sticker[]) {
        int result = 0;

        int len = sticker.length;
        
        if (sticker.length == 1) return sticker[0];

        int[] arr1 = new int[len];
        int[] arr2 = new int[len];
        
        arr1[0] = sticker[0];
        arr1[1] = sticker[0];
        for (int i = 2; i < len-1; i++) {
            arr1[i] = Math.max(arr1[i - 1], arr1[i - 2] + sticker[i]);
        }

        arr2[0] = 0;
        arr2[1] = sticker[1];
        for (int i = 2; i < len; i++) {
            arr2[i] = Math.max(arr2[i - 1], arr2[i - 2] + sticker[i]);
        }

        result = Math.max(arr1[len-2], arr2[len-1]);

        return result;
    }
}