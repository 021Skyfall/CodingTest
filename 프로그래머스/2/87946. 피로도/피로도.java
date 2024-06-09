class Solution {
    private int maxDungeons = 0;
    
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        exploreDungeons(k, dungeons, visited, 0);
        return maxDungeons;
    }

    private void exploreDungeons(int currentFatigue, int[][] dungeons, boolean[] visited, int count) {
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && currentFatigue >= dungeons[i][0]) {
                visited[i] = true;
                exploreDungeons(currentFatigue - dungeons[i][1], dungeons, visited, count + 1);
                visited[i] = false;
            }
        }
        maxDungeons = Math.max(maxDungeons, count);
    }
}