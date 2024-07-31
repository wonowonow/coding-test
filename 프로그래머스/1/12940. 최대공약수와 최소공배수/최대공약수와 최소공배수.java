class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        
        int min = Math.min(n, m);
        int max = Math.max(n, m);
        
        // 최대공약수
        for(int i = 1; i <= max; i++) {
            if (min % i == 0 && max % i == 0) {
                answer[0] = i;
            }
        }
        
        // 최소공배수
        int minGongbaesoo = min*max;
        answer[1] = minGongbaesoo / answer[0];
        
        return answer;
    }
}