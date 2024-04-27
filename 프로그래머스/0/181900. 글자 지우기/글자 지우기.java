import java.util.*;

class Solution {
    public String solution(String my_string, int[] indices) {
        Set<Integer> set = new HashSet<>();
        String answer = "";
        
        for (int i : indices) {
            set.add(i);
        }
        
        for (int i = 0; i < my_string.length(); i++) {
            if (!set.contains(i)) {
                answer += my_string.charAt(i);
            }
        }
        
        return answer;
    }
}