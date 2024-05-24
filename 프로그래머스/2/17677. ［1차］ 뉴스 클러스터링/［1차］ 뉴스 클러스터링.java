import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        addMap(map1, str1);
        addMap(map2, str2);
        
        int size = 0;
        int cnt = 0;
        
        Set<String> allKeys = new HashSet<>(map1.keySet());
        allKeys.addAll(map2.keySet());
        
        for (String key : allKeys) {
            int cnt1 = map1.getOrDefault(key, 0);
            int cnt2 = map2.getOrDefault(key, 0);
            
            cnt += Math.min(cnt1, cnt2);
            size += Math.max(cnt1, cnt2);
        }
        
        if (size == 0) {
            return 65536;
        } else {
            double sim = (double) cnt / size;
            return (int) (sim * 65536);
        }
    }
    
    public void addMap(Map<String, Integer> map, String str) {
        
        Queue<Character> q = new LinkedList<>();
        System.out.println("자 원래는? : " + str);
        for (char c : str.toCharArray()) {
            if (isAlphabet(c)) {
                q.add(c);
                
                if (q.size() == 2) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(q.poll());
                    sb.append(q.peek());
                    String key = sb.toString();
                    System.out.println("자 들어갑니다~ : " + key);
                    map.put(key, map.getOrDefault(key, 0) + 1);
                    System.out.println("자 확인!! : " + map.get(key));
                }
            } else {
                if(q.size() > 0) {
                    q.poll();
                }
            }
        }
    }
    
    public boolean isAlphabet(char c) {
        
        if ('a' <= c && c <= 'z') {
            return true;
        } else {
            return false;
        }
    }
}