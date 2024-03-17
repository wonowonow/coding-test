import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        int count = 0;
        List<String> list = new ArrayList<>();
        list.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            char beforeLast = words[i-1].charAt(words[i-1].length() - 1);
            char currentFirst = words[i].charAt(0);
            
            if (beforeLast != currentFirst) {
                count = i + 1;
                break;
            } else if (list.contains(words[i])) {
                count = i + 1;
                break;
            } else {
                list.add(words[i]);
            }
        }

        if (count != 0) {
            int round = count / n + 1;
            int other = count % n;
            
            answer[0] = other;
            answer[1] = round;
            if (other == 0) {
                answer[0] = n;
                answer[1] = round - 1;
            }
        }

        return answer;
    }
}