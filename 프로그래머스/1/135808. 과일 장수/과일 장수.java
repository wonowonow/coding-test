import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        List<Integer> scoreList = new ArrayList<>();
        for(int i : score) {
            scoreList.add(i);
        }
        scoreList.sort(Comparator.reverseOrder());
        
        for(int i = 0; i < scoreList.size();) {
            int[] appleBox = new int[m];
            for(int j = 0; j < appleBox.length; j++) {
                if(i < scoreList.size()) {
                    appleBox[j] = scoreList.get(i);
                    i++;
                }//
            }
            answer += appleBox[appleBox.length-1] * m;
        }
        
        return answer;
    }
}