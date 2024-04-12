import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        for (int i = 0; i < scoville.length; i++) {
            q.add(scoville[i]);
        }
        
        while (q.peek() < K) {
            if (q.size() == 1) {
                return -1;
            }
            q.add(q.poll() + q.poll() * 2);
            answer++;
        }
        
        
        return answer;
    }
}