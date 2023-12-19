import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        if (arr.length <= 1) {
            int[] answer = {-1};
            return answer;
        }
        
        int count = 0;
        int minInt = arr[0];
        
        for(int i = 1; i < arr.length; i++) {
            minInt = Math.min(minInt, arr[i]);
            count++;
        }
        
        List<Integer> ansList = new ArrayList<>();
        
        for(int i = 0; i < arr.length; i++) {
            if (arr[i] != minInt) {
                ansList.add(arr[i]);
            }
        }
        
        int[] answer = new int[ansList.size()];
        
        answer = ansList.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
}