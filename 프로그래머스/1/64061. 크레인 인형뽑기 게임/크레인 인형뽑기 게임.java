import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < moves.length; i++) {
            
            int idx = moves[i] - 1;
            
            for (int j = 0; j < board.length; j++) {
                
                int now = board[j][idx];
                
                if (now != 0) {
                    if (!stack.isEmpty() && stack.peek() == now) {
                        board[j][idx] = 0;
                        stack.pop();
                        answer += 2;
                        break;
                    } else {
                        board[j][idx] = 0;
                        stack.push(now);
                        break;
                    }
                }
            }
        }
        
        return answer;
    }
}