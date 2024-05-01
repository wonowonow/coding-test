class Solution {
    public int solution(int[] common) {
        int answer = 0;
        int a = 0;
        a = common[1] - common[0];
        boolean isduncha = false;
        if (common.length > 2 && common[2] - common[1] == a) {
            isduncha = true;
        }
        
        if (isduncha) {
            answer = common[common.length - 1] + a;
        } else {
            answer = common[common.length - 1] * (common[1] / common[0]);
        }
        
        return answer;
    }
}