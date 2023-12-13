import java.util.*;
class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        List<String> arr = new ArrayList<>();
        
        for(int i = 0; i < strings.length; i++) {
            
            arr.add(strings[i].substring(n,n+1) + strings[i]);
        }
        
        Collections.sort(arr);
        
        for(int i = 0; i < answer.length; i++) {
            
            answer[i] = arr.get(i).substring(1);
        }
        return answer;
    }
}