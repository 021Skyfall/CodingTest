import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int[] com : commands) {
            int[] cut = Arrays.copyOfRange(array, com[0] - 1, com[1]);
            Arrays.sort(cut);
            list.add(cut[com[2] - 1]);
        }
        
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}