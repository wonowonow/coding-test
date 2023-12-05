import java.util.*;
class Solution {
    public String solution(int a, int b) {
        String answer = "";
        String[] days = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        int[] date = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int all = 0;
        for (int i = 0; i < a-1; i++) {
            all += date[i];
        }
        
        all += (b - 1);
        answer = days[all % 7];
        
        return answer;
    }
}