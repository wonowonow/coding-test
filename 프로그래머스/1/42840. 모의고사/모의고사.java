import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        List<Integer> maxSupo = new ArrayList<>();
        int[] supos = new int[3];
        int[] oneAns = {1,2,3,4,5};
        int[] twoAns = {2,1,2,3,2,4,2,5};
        int[] threeAns = {3,3,1,1,2,2,4,4,5,5};
        
        for(int i = 0; i < answers.length; i++) {
            
            if (oneAns[i % 5] == answers[i]) {
                supos[0]++;
            }
            if (twoAns[i % 8] == answers[i]) {
                supos[1]++;
            }
            if (threeAns[i % 10] == answers[i]) {
                supos[2]++;
            }
        }
        
        int max = Math.max(supos[0], (Math.max(supos[1], supos[2])));
        
        for(int i = 0; i < supos.length; i++) {
            
            if(max == supos[i]) {
                maxSupo.add(i+1);
            }
        }
        
        int[] answer = new int[maxSupo.size()];
        
        for(int i = 0; i < answer.length; i++) {
            answer[i] = maxSupo.get(i);
        }
        
        return answer;
    }
}