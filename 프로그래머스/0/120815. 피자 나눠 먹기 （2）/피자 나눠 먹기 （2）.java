class Solution {
    public int solution(int n) {
        
        int cnt = 1;
        
        while (6 * cnt % n != 0) {
            
            cnt++;
        }
        
        return cnt;
    }
}