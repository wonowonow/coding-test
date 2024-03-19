import java.util.*;

class Solution {
    public int solution(int[] elements) {
        // 1. 중복 없는 Set
        Set<Integer> set = new HashSet<>();
        int start = 1;
        
        while (start <= elements.length) {
            
            for (int i = 0; i < elements.length; i++) {
                int value = 0;
                for (int j = i; j < i + start; j++) {
                    
                    value += elements[j % elements.length];
                }
                set.add(value);
            }
            
            start++;
        }
        
        
        // Set size 리턴
        return set.size();
    }
}