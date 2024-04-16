import java.util.*;

class Solution {
    public int[] solution(int[] numbers, String direction) {
        LinkedList<Integer> answer = new LinkedList<>();

        for (int num : numbers) {
            answer.add(num);
        }

        if (direction.equals("right")) {
            answer.addFirst(answer.pollLast());
        } else {
            answer.addLast(answer.pollFirst());
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}