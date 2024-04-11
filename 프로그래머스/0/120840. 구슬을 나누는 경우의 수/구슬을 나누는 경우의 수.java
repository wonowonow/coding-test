class Solution {
    public double solution(int balls, int share) {
        
        return Math.round(factorial(balls) / (factorial(balls - share) * factorial(share)));
    }
    
    public double factorial(int n) {
        if (n == 1) {
            return 1;
        }
        
        double answer = 1;
        for (int i = 2; i <= n; i++) {
            answer *= i;
        }
        
        return answer;
    }
}
