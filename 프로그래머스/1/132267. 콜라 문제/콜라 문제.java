class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        for(int i = n; i >= a; i -= a) {
            i += b;
            answer += b;
        }
        return answer;
    }
}