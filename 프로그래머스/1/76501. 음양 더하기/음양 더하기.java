class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 123456789;
        int sum = 0;
        for(int i = 0; i < absolutes.length; i++) {
            if(signs[i] == false) {
                sum += absolutes[i] - absolutes[i] * 2;
            } else {
                sum += absolutes[i];
            }
        }
        return answer = sum;
    }
}