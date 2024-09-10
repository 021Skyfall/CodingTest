import java.util.HashSet;

class Solution {
    public int solution(String dirs) {
        HashSet<String> visited = new HashSet<>();
        int x = 0, y = 0;

        for (char dir : dirs.toCharArray()) {
            int newX = x, newY = y;

            switch (dir) {
                case 'U':
                    if (y < 5) newY++;
                    break;
                case 'D':
                    if (y > -5) newY--;
                    break;
                case 'L':
                    if (x > -5) newX--;
                    break;
                case 'R':
                    if (x < 5) newX++;
                    break;
            }

            // 양방향
            if (newX != x || newY != y) {
                String path = x + "," + y + "->" + newX + "," + newY;
                String reversePath = newX + "," + newY + "->" + x + "," + y;
                visited.add(path);
                visited.add(reversePath);
                x = newX;
                y = newY;
            }
        }

        return visited.size() / 2;
    }
}