import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        Map<Integer, Integer> m1 = new HashMap<>();
        Map<Integer, Integer> m2 = new HashMap<>();
        
        for (int n : topping) {
            m2.put(n, m2.getOrDefault(n, 0) + 1);
        }
        
        for (int n : topping) {
            m1.put(n, m1.getOrDefault(n, 0) + 1);
            m2.put(n, m2.getOrDefault(n, 0) - 1);
            if (m2.get(n) < 1) {
                m2.remove(n);
            }
            if (m1.size() == m2.size()) {
                answer++;
            }
        }
        
        return answer;
    }
}