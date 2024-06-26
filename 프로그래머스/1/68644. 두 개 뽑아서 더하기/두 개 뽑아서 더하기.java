import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> numberSet = new TreeSet<>();
        
        for(int i = 0; i < numbers.length; i++) {
            for(int j = i+1; j < numbers.length; j++) {
                numberSet.add(numbers[i] + numbers[j]);
            }
        }
        Iterator<Integer> numberIter = numberSet.iterator();
        
        int[] answer = new int[numberSet.size()];
        int count = 0;
        while(numberIter.hasNext()) {
            answer[count] = numberIter.next();
            count++;
        }
        
        return answer;
    }
}