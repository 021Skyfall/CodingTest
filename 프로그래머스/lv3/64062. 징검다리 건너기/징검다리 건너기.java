class Solution {
    public int solution(int[] stones, int k) {
        int left = 1;
        int right = Integer.MAX_VALUE;
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            int zero = 0;
            boolean possible = true;

            for (int stone : stones) {
                if (stone < mid) {
                    zero++;
                    if (zero >= k) {
                        possible = false;
                        break;
                    }
                } else {
                    zero = 0;
                }
            }

            if (possible) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }
}