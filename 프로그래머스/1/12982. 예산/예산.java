import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        
        for(int i = 0; i < d.length; i++) {
            
            for(int j = 1; j < d.length-i; j++) {
                    if(d[j-1] > d[j]) {
                    int tmp = d[j-1];
                    d[j-1] = d[j];
                    d[j] = tmp;
                }
            }
        }
        
        for(int i = 0; i < d.length; i++) {
            System.out.println(d[i]);
        }
        
        for(int i = 0; i < d.length; i++) {
            
            if (budget - d[i] >= 0) {
                budget = budget - d[i];
                answer++;
            }
        }
        
        return answer;
    }
}