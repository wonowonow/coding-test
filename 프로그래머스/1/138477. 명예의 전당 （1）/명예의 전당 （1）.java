import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        List<Integer> kList = new ArrayList<>();
        
        for (int i = 0; i < answer.length; i++) {
            if (kList.size() < k) {
                kList.add(score[i]);
                kList.sort(Comparator.reverseOrder());
                answer[i] = kList.get(i);
                continue;
            }
            kList.add(score[i]);
            kList.sort(Comparator.reverseOrder());
            answer[i] = kList.get(k-1);
        }
        
        return answer;
    }
}