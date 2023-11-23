import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.split("");
        
        int count = 0;
        
        for (String str : arr) {
            count = str.equals(" ") ? 0 : count+1;
            answer += count % 2 == 1 ? str.toUpperCase() : str.toLowerCase();
        }
        
        return answer;
    }
}