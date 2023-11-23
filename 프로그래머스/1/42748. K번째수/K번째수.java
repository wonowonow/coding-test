import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int count = 0;
        for (int i = 0; i < commands.length; i++) {
            if (commands[i][1] - commands[i][0] == 0) {
                answer[i] = array[commands[i][0]-1];
            } else {
                int[] temp = new int[commands[i][1] - commands[i][0]+1];
                for (int j = commands[i][0] - 1; j < commands[i][1]; j++) {
                    temp[count] = array[j];
                    count++;
                }
                Arrays.sort(temp);
                answer[i] = temp[commands[i][2]-1];
                count = 0;
            }
        }
        return answer;
    }
}