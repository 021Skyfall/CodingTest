class Solution {
    public int[] solution(String[] park, String[] routes) {
        int rows = park.length;
        int cols = park[0].length();
        int[] start = new int[2];

        // 시작 위치
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (park[i].charAt(j) == 'S') {
                    start[0] = i; // 행
                    start[1] = j; // 열
                    break;
                }
            }
        }

        int x = start[0];
        int y = start[1];

        for (String route : routes) {
            String[] parts = route.split(" ");
            String direction = parts[0];
            int distance = Integer.parseInt(parts[1]);
            int newX = x;
            int newY = y;
            boolean canMove = true;

            for (int d = 0; d < distance; d++) {
                if (direction.equals("N")) newX--;
                else if (direction.equals("S")) newX++;
                else if (direction.equals("W")) newY--;
                else if (direction.equals("E")) newY++;

                // 벽, 장애물
                if (newX < 0 || newX >= rows || newY < 0 || newY >= cols || park[newX].charAt(newY) == 'X') {
                    canMove = false;
                    break;
                }
            }

            if (canMove) {
                x = newX;
                y = newY;
            }
        }

        return new int[]{x, y};
    }
}