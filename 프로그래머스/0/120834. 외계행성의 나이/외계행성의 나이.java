import java.util.*;

class Solution {
    public String solution(int age) {
        String answer = "";
        
        for (char c : String.valueOf(age).toCharArray()) {
            
            answer += (char) ((char) c + 49);
        }
        return answer;
    }
}