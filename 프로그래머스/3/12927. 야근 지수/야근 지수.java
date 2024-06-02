import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (o1, o2) -> {
                return o2 - o1;
            }
        );
        
        for (int work : works) {
            pq.add(work);
        }
        
        while (n > 0) {
            int num = pq.poll();
            if (num == 0) {
                return 0;
            }
            pq.add(num - 1);
            n--;
        }
        
        while (!pq.isEmpty()) {
            int num = pq.poll();
            System.out.println(num);
            answer += Math.pow(num, 2);
        }
        
        return answer;
    }
}