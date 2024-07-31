class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < section.length; j++) {
                if(section[j] == i) {
                    answer++;
                    i += m;
                }
            }
        }
        
        return answer;
    }
}