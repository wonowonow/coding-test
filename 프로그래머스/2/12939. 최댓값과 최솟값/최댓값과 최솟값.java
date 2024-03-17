import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] splitArr = s.split(" ");
        
        int[] intArr = new int[splitArr.length];
        
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(splitArr[i]);
        }
        
        int full = Integer.MIN_VALUE;
        int less = Integer.MAX_VALUE;
        
        for (int i = 0; i < intArr.length; i++) {
            full = Math.max(full, intArr[i]);
            less = Math.min(less, intArr[i]);
        }
        
        answer += String.valueOf(less);
        answer += " ";
        answer += String.valueOf(full);
        
        return answer;
    }
}