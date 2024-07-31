class Solution {
    public String solution(String s) {
        String answer = "";
        int i = s.length()/2;
        if(s.length() % 2 == 0) {
            answer += s.substring(i-1,i+1);
        }
        if(s.length() % 2 == 1) {
            answer += s.substring(i,i+1);
        }
        return answer;
    }
}