import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        
        Deque<Integer> arrStack = new ArrayDeque<>();
        
        arrStack.add(arr[0]);
        for(int i = 1; i < arr.length; i++) {
            
            if(arrStack.peekLast() == arr[i]) {
                continue;
            } else {
                arrStack.addLast(arr[i]);
            }
        }
        
        int[] answer = new int[arrStack.size()];
        
        for(int i = 0; i < answer.length; i++) {
            answer[i] = arrStack.poll();
        }

        return answer;
    }
}