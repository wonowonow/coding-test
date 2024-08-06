import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        
        for (int i = 0; i < numbers.length; i++) {
            
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                int now = stack.pop();
                answer[now] = numbers[i];
            }
            
            stack.push(i);
        }
        
        while (!stack.isEmpty()) {
            int now = stack.pop();
            answer[now] = -1;
        }
        
        
        return answer;
    }
}