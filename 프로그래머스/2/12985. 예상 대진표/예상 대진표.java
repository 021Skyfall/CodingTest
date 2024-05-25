class Solution
{
    public int solution(int n, int a, int b)
    {
        int round = 0;
        
        while(a != b) {
            a = a / 2 + a % 2; // a가 홀수라면 다음 라운드에서의 번호는 (a+1)/2, 짝수라면 a/2
            b = b / 2 + b % 2; // b에 대해서도 동일하게 적용
            round++; // 라운드를 1 증가
        }
        
        return round;
    }
}