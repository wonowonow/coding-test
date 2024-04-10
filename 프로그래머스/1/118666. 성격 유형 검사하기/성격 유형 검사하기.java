import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        Map<Character, Integer> map = new HashMap<>();
        
        map.put('R', 0);
        map.put('T', 0);
        map.put('F', 0);
        map.put('C', 0);
        map.put('M', 0);
        map.put('J', 0);
        map.put('A', 0);
        map.put('N', 0);
        
        for (int i = 0; i < survey.length; i++) {
            
            if (choices[i] < 4) {
                char sur = survey[i].charAt(0);
                map.replace(sur, map.get(sur) + 4 - choices[i]);
            } else if (choices[i] > 4) {
                char sur = survey[i].charAt(1);
                map.replace(sur, map.get(sur) + choices[i] - 4);
            }
        }
        
        answer = calculator(answer, map, 'R', 'T');
        answer = calculator(answer, map, 'C', 'F');
        answer = calculator(answer, map, 'J', 'M');
        answer = calculator(answer, map, 'A', 'N');
        
        return answer;
    }
    
    public String calculator(String answer, Map<Character, Integer> map, char o1, char o2) {
        String o3 = "";
        int o1Cnt = map.get(o1);
        int o2Cnt = map.get(o2);
        
        if (o1Cnt == o2Cnt) {
            
            return answer += (char) Math.min(o1, o2);
        }
        
        if (o1Cnt > o2Cnt) {
            o3 += o1;
        } else {
            o3 += o2;
        }
        
        return answer += o3;
    }
}