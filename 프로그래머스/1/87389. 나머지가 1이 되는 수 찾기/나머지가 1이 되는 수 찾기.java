class Solution {
    public int solution(int n) {
        int answer = 0;
        int i = 1;
        while(n % i != 1) {
            i++;
        }
        answer = i;
        return answer;
    }
}