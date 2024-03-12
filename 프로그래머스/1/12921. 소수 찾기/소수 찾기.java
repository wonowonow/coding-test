import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int[] A = new int[n + 1];
        
        for (int i = 2; i <= n; i++) {
            A[i] = i;
        }
        
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (A[i] == 0) {
                continue;
            }
            
            for (int j = i + i; j <= n; j = j + i) {
                A[j] = 0;
            }
        }
        
        for (int i = 2; i <= n; i++) {
            if (A[i] != 0) {
                answer++;
            }
        }
        return answer;
    }
}