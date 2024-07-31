class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        for (int i = 0; i < s.length(); i++) {
            if(s.length() != 4 && s.length() != 6) {
                answer = false;
            }
            if (('a' <= s.charAt(i) && s.charAt(i) >= 'z') || ('A' <= s.charAt(i) && s.charAt(i) >= 'Z')) {
                answer = false;
                break;
            }
        }
        return answer;
    }
}