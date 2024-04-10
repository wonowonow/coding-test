import java.util.*;

class Solution {
    public int[] solution(String my_string) {
        my_string = my_string.replaceAll("[^0-9]", "");
        int[] answer = new int[my_string.length()];
        int cnt = 0;
        for (String number : my_string.split("")) {
            answer[cnt] = Integer.parseInt(number);
            cnt++;
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
}