import java.util.*;

class Solution {
    public String solution(String my_string) {
        String answer = "";
        Set<Character> charSet = new HashSet<>();
        
        for (int i = 0; i < my_string.length(); i++) {
            
            char c = my_string.charAt(i);
            if (!charSet.contains(c)) {
                answer += c;
                charSet.add(c);
            }
        }
        
        return answer;
    }
}