import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        
        Map<String, Integer> map = new HashMap<>();
        
        int cnt = 1;
        for (int i = 'A'; i <= 'Z'; i++) {
            map.put(String.valueOf((char)i), cnt++);
        }
        
        while (msg.length() != 0) {
            
            String record = "";
            int maxLength = 0;
            for (String key : map.keySet()) {
                if (msg.indexOf(key) == 0 && key.length() > maxLength) {
                    maxLength = key.length();
                    record = key;
                }
            }
            answer.add(map.get(record));
            if (msg.length() > record.length()) {
                map.put(msg.substring(0, record.length() + 1), map.size() + 1);
            }

            msg = msg.substring(record.length());
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}