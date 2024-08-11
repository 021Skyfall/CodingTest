class Solution {
    public long solution(int price, int money, int count) {
        long totalCost = price * (long) count * (count + 1) / 2;
        
        long shortage = totalCost - money;

        return Math.max(shortage, 0);
    }
}