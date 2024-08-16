import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        
        int count = 0;
        int sum = 0;
        
        for (int i = 0; i < bridge_length; i++) {
            queue.add(0);
        }
        
        while (!queue.isEmpty()) {
            
            answer++;
            sum -= queue.poll();
            
            if (count < truck_weights.length) {
                if (sum + truck_weights[count] <= weight) {
                    queue.add(truck_weights[count]);
                    sum = sum + truck_weights[count];
                    count++;
                } else {
                    queue.add(0);
                }
            }

        }
        
        return answer;
    }
}