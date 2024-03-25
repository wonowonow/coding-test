import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        
        Queue<Integer> q = new LinkedList<>();
        // 큐에 모든거 넣기
        for(int i = 0; i < progresses.length; i++) {
            q.add(progresses[i]);
        }
        
        // 곱count++ 해가면서 만약 q.peek() + speeds[speedCnt] * 곱cnt >= 100 이면 remove
        int mCnt = 1;
        int sCnt = 0;
        int sum = 0;
        while (!q.isEmpty()) {
            if (q.peek() + speeds[sCnt] * mCnt >= 100) {
                q.remove();
                sCnt++;
                sum++;
            } else if (q.peek() + speeds[sCnt] * mCnt < 100 && sum == 0) {
                mCnt++;
            } else if (q.peek() + speeds[sCnt] * mCnt < 100 && sum > 0) {
                list.add(sum);
                sum = 0;
            }
        }
        list.add(sum);
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}