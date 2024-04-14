class Solution {
    public String solution(String myString) {
        String answer = "";
        
        for (char c : myString.toCharArray()) {
            
            if (c <= 'l') {
                c = 'l';
            }
            
            answer += c;
        }
        
        return answer;
    }
}