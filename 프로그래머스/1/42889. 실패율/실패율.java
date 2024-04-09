import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] successPlayer = new int[N];
        int[] failPlayer = new int[N];
        
        for (int i = 0; i < stages.length; i++) {
            if (stages[i] <= N) {
                failPlayer[stages[i] - 1]++;
            }
            for (int j = 0; j < stages[i] - 1; j++) {
                if (j < N) {
                    successPlayer[j]++;
                }
            }
        }
        
        double[][] failRate = new double[N][2];
        
        for (int i = 0; i < N; i++) {
            if (failPlayer[i] == 0) {
                failRate[i][1] = 0;
            } else {
                failRate[i][1] = (double) failPlayer[i] / successPlayer[i];
            }
            failRate[i][0] = i + 1;
        }
        
        Arrays.sort(failRate, (a, b) -> Double.compare(b[1], a[1]));
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = (int) failRate[i][0];
        }
        
        return answer;
    }
}