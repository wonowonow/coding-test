import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> compCount = new HashMap<>();
        
        for (int i = 0; i < participant.length; i++) {
            
            if (compCount.containsKey(participant[i])) {
                compCount.put(participant[i], compCount.get(participant[i]) + 1);
            } else {
                compCount.put(participant[i], 1);
            }
        }
        
        for (int i = 0; i < completion.length; i++) {
            
            if (compCount.containsKey(completion[i])) {
                compCount.put(completion[i], compCount.get(completion[i]) - 1);
            }
        }
        
        
        for (int i = 0; i < participant.length; i++) {
            
            if (compCount.get(participant[i]) != 0) {
                answer = participant[i];
            }
        }
        
        return answer;
    }
}