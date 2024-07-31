class Solution {
    public int solution(int num) {
        int answer = 0;
        int total = 0;
        for(int i = 0; i <= 500; i++) {
            if(num == 1) {
                answer = i;
                break;
            } else if (i == 500) {
                answer = -1;
                break;
            }
            if (num % 2 == 0) {
                num /= 2;
            } else if (num % 2 == 1) {
                num *= 3;
                num += 1;
            }
        }
        return answer;
    }
}