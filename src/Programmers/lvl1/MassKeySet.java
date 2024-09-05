package Programmers.lvl1;

import java.util.*;

public class MassKeySet {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"AA"}, new String[]{"B"})));
    }

    public static int[] solution(String[] keymap, String[] targets) {
        int[] result = new int[targets.length];

        for (int i = 0; i < targets.length; i++) {
            String target = targets[i];
            ArrayList<Integer> counts = new ArrayList<>();

            for (int j = 0; j < target.length(); j++) {
                char tar = target.charAt(j);
                int count = Integer.MAX_VALUE;

                for (String keys : keymap) {
                    for (int k = 0; k < keys.length(); k++) {
                        if (keys.charAt(k) == tar) {
                            count = Math.min(count, k + 1);
                            break;
                        }
                    }
                }

                if (count == Integer.MAX_VALUE) {
                    counts.add(-1);
                } else {
                    counts.add(count);
                }
            }


            int min = Collections.min(counts);

            if (min == -1) {
                result[i] = -1;
            } else {
                result[i] = counts.stream().mapToInt(Integer::intValue).sum();
            }
        }

        return result;
    }
}

    // 개선
//    public static int[] solution(String[] keymap, String[] targets) {
//        int[] result = new int[targets.length];
//
//        // 자판에 대한 누르기 횟수를 저장할 HashMap
//        HashMap<Character, Integer> keyPressCounts = new HashMap<>();
//
//        // 각 자판의 키에 대해 최소 누르기 횟수 계산
//        for (String keys : keymap) {
//            for (int k = 0; k < keys.length(); k++) {
//                char key = keys.charAt(k);
//                keyPressCounts.put(key, Math.min(keyPressCounts.getOrDefault(key, Integer.MAX_VALUE), k + 1));
//            }
//        }
//
//        // 각 타겟 문자열 처리
//        for (int i = 0; i < targets.length; i++) {
//            String target = targets[i];
//            int totalPresses = 0;
//            boolean isPossible = true;
//
//            for (char ch : target.toCharArray()) {
//                Integer count = keyPressCounts.get(ch); // 해당 문자의 누르기 횟수 가져오기
//                if (count == null) { // 문자가 자판에 없는 경우
//                    isPossible = false;
//                    break;
//                }
//                totalPresses += count; // 누르기 횟수 합산
//            }
//
//            // 결과 저장
//            result[i] = isPossible ? totalPresses : -1; // 가능하면 총 누르기 횟수, 불가능하면 -1
//        }
//
//        return result;
//    }
//}
