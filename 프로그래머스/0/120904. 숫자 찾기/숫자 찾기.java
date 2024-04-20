class Solution {
    public int solution(int num, int k) {
        int answer = 0;
        if (String.valueOf(num).contains(String.valueOf(k))) {
            answer = String.valueOf(num).indexOf(String.valueOf(k)) + 1;
        } else {
            answer = -1;
        }
        return answer;
    }
}