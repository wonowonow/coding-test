import java.util.*;

class Solution {
    static Map<String, Integer> map = new HashMap<>();
    static int answer = 0;
    
    public int solution(String[] want, int[] number, String[] discount) {
        
        for (int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }
        
        int left = 0;
        int right = 10;
        
        for (int i = 0; i < 10; i++) {
            if (map.containsKey(discount[i])) {
                map.put(discount[i], map.get(discount[i]) - 1);
            }
        }
        if (checkMyWant()) {
            answer++;
        }
        
        while (right < discount.length) {
            // 왼쪽 지우기
            if (map.containsKey(discount[left])) {
                map.put(discount[left], map.get(discount[left]) + 1);
            }
            
            // 오른쪽 추가하기
            if (map.containsKey(discount[right])) {
                map.put(discount[right], map.get(discount[right]) - 1);
            }
            
            if (checkMyWant()) {
                answer++;
            }
            left++;
            right++;
        }
        
        return answer;
    }
    
    public boolean checkMyWant() {
        
        for (String want : map.keySet()) {
            if (map.get(want) > 0) {
                return false;
            }
        }
        
        return true;
    }
}