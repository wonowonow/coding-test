import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        List<Integer> ansList = new ArrayList<>();
        Set<Integer> numberSet = new TreeSet<>();
        
        for(int i = 0; i < numbers.length; i++) {
            
            for(int j = 0; j < numbers.length; j++) {
                if (i == j) {
                    continue;
                }
                numberSet.add(numbers[i] + numbers[j]);
            }
        }
        Iterator<Integer> numberIter = numberSet.iterator();
        
        while(numberIter.hasNext()) {
            ansList.add(numberIter.next());
        }
        
        int[] answer = new int[ansList.size()];
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = ansList.get(i);
        }
        
        return answer;
    }
}