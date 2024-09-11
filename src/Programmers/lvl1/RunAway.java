package Programmers.lvl1;

import java.util.*;

public class RunAway {
    public static void main(String[] args) throws java.io.IOException {
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "soe"};

        String[] result = solution(players, callings);
        System.out.println(Arrays.toString(result));
    }

    public static String[] solution(String[] players, String[] callings) {
        Map<String, Integer> playerMap = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            playerMap.put(players[i], i);
        }

        for (String calling : callings) {
            int idx = playerMap.get(calling);
            if (idx > 0) {
                String frontPlayer = players[idx - 1];
                players[idx] = frontPlayer;
                players[idx - 1] = calling;

                playerMap.put(calling, idx - 1);
                playerMap.put(frontPlayer, idx);
            }
        }

        return players;
    }
}
