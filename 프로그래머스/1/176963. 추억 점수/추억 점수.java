import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        
        Map<String, Integer> nameScores = new HashMap<>();
        
        for (int i = 0; i < name.length; i++) {
            
            nameScores.put(name[i], yearning[i]);
        }
        
        for (int i = 0; i < photo.length; i++) {
            
            for (int j = 0; j < photo[i].length; j++) {
                
                if(nameScores.containsKey(photo[i][j])) {
                    answer[i] += nameScores.get(photo[i][j]);
                }
            }
        }
        
        return answer;
    }
}