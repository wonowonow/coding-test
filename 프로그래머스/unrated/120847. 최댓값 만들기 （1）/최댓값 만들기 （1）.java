import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        Integer[] numbersObj = Arrays.stream(numbers).boxed().toArray(Integer[]::new);
        Arrays.sort(numbersObj, Collections.reverseOrder());
        
        return numbersObj[0] * numbersObj[1];
    }
}