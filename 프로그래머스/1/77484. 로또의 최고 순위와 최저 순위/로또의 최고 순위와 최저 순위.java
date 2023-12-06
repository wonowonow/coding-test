class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int count = 0;
        int zeroCount = 0;
        int max = 7;
        int min = 7;
        for(int i = 0; i < lottos.length; i++) {
            if (lottos[i] == 0) {
                zeroCount++;
                continue;
            }
            for(int j = 0; j < win_nums.length; j++) {
                if (lottos[i] == win_nums[j]) {
                    count++;
                }
            }
        }
        
        max -= count+zeroCount;
        min -= count;
        if(max == 7) {
            max = 6;
        }
        if(min == 7) {
            min = 6;
        }
        answer[0] = max;
        answer[1] = min;
        
        return answer;
    }
}