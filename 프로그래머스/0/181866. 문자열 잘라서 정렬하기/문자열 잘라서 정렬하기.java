import java.util.*;

class Solution {
    public String[] solution(String myString) {
        List<String> answer = new ArrayList<>();
        
        for (String str : myString.replaceAll("[^a-z]", "").split("x")) {
            
            if (!str.isEmpty()) {
                answer.add(str);
            }
        }
        
        Collections.sort(answer);
        
        return answer.stream().toArray(String[]::new);
    }
}