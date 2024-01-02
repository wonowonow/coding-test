class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for(int i = 1; i <= n; i++) {
            
            int yakCount = 0;
            for(int j = 1; j <= i; j++) {
                
                if(i % j == 0) {
                    yakCount++;
                }
            }
            if(yakCount >= 3) {
                answer++;
            }
        }
        
        return answer;
    }
}