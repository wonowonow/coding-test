import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        Comparator<String> comparator = new Comparator<>() {
            @Override
            public int compare(String o1, String o2) {
                String n1 = o1 + o2;
                String n2 = o2 + o1;
                
                return n2.compareTo(n1);
            }
        };
        
        String[] numArr = new String[numbers.length];
        
        for (int i = 0; i < numArr.length; i++) {
            numArr[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(numArr, comparator);
        
        for (int i = 0; i < numArr.length; i++) {
            answer += numArr[i];
        }
        
        if (answer.charAt(0) == '0') {
            return "0";
        }
        
        return answer;
    }
}