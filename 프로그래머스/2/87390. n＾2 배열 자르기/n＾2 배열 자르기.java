import java.util.*;

class Solution {
    public List<Long> solution(int n, long left, long right) {
        List<Long> list = new ArrayList<>();
        
        // 4: 1 2 3 4 / 2 2 3 4 / 3 3 3 4 / 4 4 4 4
        // 3: 1 2 3   / 2 2 3   / 3 3 3
        // 2: 1 2     / 2 2
        
        for (long i = left; i <= right; i++) {
            list.add(Math.max(i / n, i % n) + 1);
        }
        
        return list;
    }
}